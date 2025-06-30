package io.github.hyunjae.tool.presentation.ui.components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

data class Particle(
    var position: Offset,
    var velocity: Offset,
    val color: Color,
    var alpha: Float,
    var size: Float,
    var life: Float,
    val maxLife: Float
)
