package io.github.hyunjae.tool.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hyunjae.tool.data.repository.HabitRepositoryImpl
import io.github.hyunjae.tool.domain.repository.HabitRepository
import io.github.hyunjae.tool.domain.usecase.AddHabitUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHabitRepository(): HabitRepository {
        return HabitRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideAddHabitUseCase(habitRepository: HabitRepository): AddHabitUseCase {
        return AddHabitUseCase(habitRepository)
    }
}
