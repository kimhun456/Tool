package io.github.hyunjae.tool.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.hyunjae.tool.presentation.ui.screens.habit.AddHabitScreen
import io.github.hyunjae.tool.presentation.ui.screens.habit.HabitScreen
import io.github.hyunjae.tool.presentation.ui.screens.home.HomeScreen
import io.github.hyunjae.tool.presentation.ui.screens.settings.SettingsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Habit.route) {
            HabitScreen(navController = navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen()
        }
        composable(Screen.AddHabit.route) {
            AddHabitScreen()
        }
    }
}