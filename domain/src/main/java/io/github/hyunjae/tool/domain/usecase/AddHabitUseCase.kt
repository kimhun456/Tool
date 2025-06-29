package io.github.hyunjae.tool.domain.usecase

import io.github.hyunjae.tool.domain.model.Habit
import io.github.hyunjae.tool.domain.repository.HabitRepository

class AddHabitUseCase(private val habitRepository: HabitRepository) {
    suspend fun execute(habit: Habit) {
        return habitRepository.addHabit(habit)
    }
}