package com.qu3dena.todocompose.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

import com.qu3dena.todocompose.presentation.ui.screens.HomeScreen
import com.qu3dena.todocompose.presentation.ui.screens.TaskFormScreen
import com.qu3dena.todocompose.presentation.ui.screens.TaskListScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(
                modifier = modifier,
            )
        }

        composable(Screen.TaskList.route) {

            TaskListScreen(
                modifier = modifier,
                onNavigationToForm = {
                    navController.navigate(Screen.TaskForm.route)
                }
            )
        }

        composable(Screen.TaskForm.route) {

            TaskFormScreen(
                modifier = modifier
            )
        }
    }
}