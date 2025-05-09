package com.qu3dena.todocompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

import com.qu3dena.todocompose.presentation.ui.screens.HomeScreen
import com.qu3dena.todocompose.presentation.ui.screens.TaskFormScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(
                modifier = modifier,
                onNavigationToForm = {
                    navController.navigate(Screen.TaskForm.route)
                }
            )
        }

        composable(Screen.TaskForm.route) {
            TaskFormScreen(
                modifier = modifier,
                onSave = {
                    val canPop = navController.popBackStack()
                    if (!canPop) {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}
