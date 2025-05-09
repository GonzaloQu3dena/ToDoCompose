package com.qu3dena.todocompose.presentation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object TaskForm : Screen("task_form_screen")
}