package io.github.hyunjae.tool.data.repository

import io.github.hyunjae.tool.domain.model.Habit
import io.github.hyunjae.tool.domain.repository.HabitRepository
import timber.log.Timber
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor() : HabitRepository {
    override suspend fun addHabit(habit: Habit) {
        Timber.d("HabitRepositoryImpl: Adding habit: ${habit.name} with ID: ${habit.id}")
        // 실제 데이터베이스 또는 네트워크 호출 로직이 여기에 들어갑니다.
    }

    override suspend fun getHabits(): List<Habit> {
        Timber.d("HabitRepositoryImpl: Getting habits")
        return emptyList()
    }
}
