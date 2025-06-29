package io.github.hyunjae.tool.domain.usecase

import io.github.hyunjae.tool.domain.model.Habit
import io.github.hyunjae.tool.domain.repository.HabitRepository
import java.util.UUID

class AddHabitUseCase(private val habitRepository: HabitRepository) {
    suspend operator fun invoke(name: String) {
        val newHabit = Habit(id = UUID.randomUUID().toString(), name = name)
        habitRepository.addHabit(newHabit)
    }
}