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
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

@Composable
fun HomeScreen() {
    var currentTime by remember { mutableStateOf(Calendar.getInstance()) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = Calendar.getInstance()
            delay(1000) // Update every second
        }
    }

    var currentMinute by remember { mutableStateOf(currentTime.get(Calendar.MINUTE)) }
    var targetColor by remember { mutableStateOf(Color.Black) }
    var startColorForMinute by remember { mutableStateOf(Color.Black) }

    LaunchedEffect(currentTime.get(Calendar.MINUTE)) {
        if (currentTime.get(Calendar.MINUTE) != currentMinute) {
            currentMinute = currentTime.get(Calendar.MINUTE)
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
        targetValue = lerp(
            startColorForMinute,
            targetColor,
            currentTime.get(Calendar.SECOND) / 59f
        ),
        label = "clockColorAnimation"
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(currentTime.time),
            style = MaterialTheme.typography.displayLarge,
            color = animatedColor
        )
    }
}