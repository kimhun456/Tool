package io.github.hyunjae.tool.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object Habit : Screen("habit", "Habit", Icons.Default.Person)
    data object Settings : Screen("settings", "Settings", Icons.Default.Settings)
    data object AddHabit : Screen("add_habit", "Add Habit", Icons.Default.Add)
}