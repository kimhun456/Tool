package io.github.hyunjae.tool.presentation.ui.screens.habit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hyunjae.tool.domain.usecase.AddHabitUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class AddHabitViewModel @Inject constructor(
    private val addHabitUseCase: AddHabitUseCase
) : ViewModel() {

    fun addHabit(name: String) {
        viewModelScope.launch {
            addHabitUseCase(name)
        }
    }
}
