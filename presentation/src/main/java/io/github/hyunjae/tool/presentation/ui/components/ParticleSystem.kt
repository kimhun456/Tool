package io.github.hyunjae.tool.presentation.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import kotlin.random.Random

@Composable
fun ParticleSystem(modifier: Modifier = Modifier, trigger: Any? = null, origin: Offset = Offset.Zero) {
    val particles = remember { mutableStateListOf<Particle>() }

    LaunchedEffect(trigger) {
        if (trigger != null) {
            // Generate new particles
            repeat(20) { // Generate 20 particles for each trigger
                val angle = Random.nextFloat() * 2 * Math.PI
                val speed = Random.nextFloat() * 10f + 5f
                particles.add(
                    Particle(
                        position = origin,
                        velocity = Offset(
                            x = (speed * kotlin.math.cos(angle)).toFloat(),
                            y = (speed * kotlin.math.sin(angle)).toFloat()
                        ),
                        color = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f),
                        alpha = 1f,
                        size = Random.nextFloat() * 10f + 5f,
                        life = 0f,
                        maxLife = Random.nextFloat() * 50f + 50f // Life in frames
                    )
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(16) // Approximately 60 FPS
            val iterator = particles.iterator()
            while (iterator.hasNext()) {
                val particle = iterator.next()
                particle.life += 1f
                if (particle.life >= particle.maxLife) {
                    iterator.remove()
                } else {
                    particle.position = particle.position.plus(particle.velocity)
                    particle.velocity = particle.velocity.plus(Offset(0f, 0.5f)) // Gravity
                    particle.alpha = 1f - (particle.life / particle.maxLife)
                    particle.size = particle.size * (particle.alpha + 0.5f) // Shrink as it fades
                }
            }
        }
    }

    Canvas(modifier = modifier) {
        particles.forEach { particle ->
            drawCircle(
                color = particle.color.copy(alpha = particle.alpha),
                radius = particle.size,
                center = particle.position
            )
        }
    }
}
