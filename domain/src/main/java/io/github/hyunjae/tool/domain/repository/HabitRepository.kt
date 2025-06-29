package io.github.hyunjae.tool.domain.repository

import io.github.hyunjae.tool.domain.model.Habit

interface HabitRepository {
    suspend fun addHabit(habit: Habit)
    suspend fun getHabits(): List<Habit>
}
