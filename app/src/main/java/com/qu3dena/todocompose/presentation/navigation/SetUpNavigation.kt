package com.qu3dena.todocompose.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

import com.qu3dena.todocompose.presentation.ui.screens.HomeScreen

/**
 * Sets up the navigation for the application.
 * This function defines the navigation graph and the screens that can be navigated to.
 * @param navHostController The NavHostController used for navigation.
 * @param modifier The modifier to be applied to the navigation host.
 */
@Composable
fun SetUpNavigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navHostController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(
                modifier = modifier,
            )
        }

        taskNavigation(modifier, navHostController)
    }
}