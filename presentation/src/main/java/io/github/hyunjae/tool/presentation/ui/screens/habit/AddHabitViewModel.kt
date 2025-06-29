package io.github.hyunjae.tool.presentation.ui.screens.habit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hyunjae.tool.domain.usecase.AddHabitUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class AddHabitViewModel @Inject constructor(
    private val addHabitUseCase: AddHabitUseCase
) : ViewModel() {

    init {
        Timber.d("AddHabitViewModel initialized")
    }

    fun addHabit(name: String) {
        Timber.d("Attempting to add habit: $name")
        viewModelScope.launch {
            addHabitUseCase(name)
            Timber.d("Habit added: $name")
        }
    }
}
