package io.github.hyunjae.tool.presentation.ui.screens.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Composable
fun HomeScreen() {
    var currentTime by remember { mutableStateOf(LocalDateTime.now()) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = LocalDateTime.now()
            delay(1000) // Update every second
        }
    }

    var currentMinute by remember { mutableStateOf(currentTime.minute) }
    var targetColor by remember { mutableStateOf(Color.Black) }
    var startColorForMinute by remember { mutableStateOf(Color.Black) }

    LaunchedEffect(currentTime.minute) {
        if (currentTime.minute != currentMinute) {
            currentMinute = currentTime.minute
            startColorForMinute = targetColor // The color at the end of the previous minute
            targetColor = Color(
                red = Random.nextFloat(),
                green = Random.nextFloat(),
                blue = Random.nextFloat(),
                alpha = 1f
            )
        }
    }

    val animatedColor by animateColorAsState(
        targetValue = lerp(startColorForMinute, targetColor, currentTime.second / 59f),
        label = "clockColorAnimation"
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
            style = MaterialTheme.typography.displayLarge,
            color = animatedColor
        )
    }
}