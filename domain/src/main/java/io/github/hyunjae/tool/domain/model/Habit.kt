package io.github.hyunjae.tool.domain.model

data class Habit(
    val id: String,
    val title: String,
    val category: HabitCategory,
    val doneDates: Map<String, Boolean> = emptyMap()
)