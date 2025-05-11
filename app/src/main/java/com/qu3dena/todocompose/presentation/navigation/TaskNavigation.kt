package com.qu3dena.todocompose.presentation.navigation

import androidx.compose.ui.Modifier

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

import com.qu3dena.todocompose.presentation.PresentationModule
import com.qu3dena.todocompose.presentation.ui.screens.TaskFormScreen
import com.qu3dena.todocompose.presentation.ui.screens.TaskListScreen

fun NavGraphBuilder.taskNavigation(
    modifier: Modifier,
    navHostController: NavHostController
) {
    val taskViewModel = PresentationModule.getTaskViewModel()

    composable(Screen.TaskList.route) {

        TaskListScreen(
            modifier = modifier,
            viewModel = taskViewModel,

            onAddTask = {
                navHostController.navigate(Screen.TaskForm.route)
            }
        )
    }

    composable(Screen.TaskForm.route) {

        TaskFormScreen(
            modifier = modifier,
            viewModel = taskViewModel,
            onTaskSaved = {
                navHostController.popBackStack()
            }
        )
    }
}