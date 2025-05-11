package com.qu3dena.todocompose.presentation.ui.screens

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material3.NavigationBar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow

import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.vector.ImageVector
import com.qu3dena.todocompose.presentation.navigation.Screen
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Main screen of the application.
 * This screen contains the app bar, navigation bar, and the main content area.
 * @param navController The NavHostController for navigation.
 * @param bodyContent The content to be displayed in the main area.
 */
@Composable
fun MainScreen(
    navController: NavHostController,
    bodyContent: @Composable (Modifier) -> Unit,
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            AppBar(modifier = Modifier.fillMaxWidth())

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                bodyContent(Modifier.fillMaxSize())
            }

            NavBar(
                modifier = Modifier.fillMaxWidth(),
                navController = navController
            )
        }
    }
}

/**
 * App bar at the top of the screen.
 * This bar contains the app title and a menu icon.
 * @param modifier The modifier to be applied to the app bar.
 */
@Composable
private fun AppBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .background(color = Color.LightGray),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    text = "ToDoCompose by Gonzalo Qu3dena"
                )
                Icon(
                    Icons.Default.MoreVert, contentDescription = null,
                )
            }
        }
    }
}

/**
 * Navigation bar at the bottom of the screen.
 * This bar contains navigation items for different screens.
 * @param navController The NavHostController for navigation.
 * @param modifier The modifier to be applied to the navigation bar.
 */
@Composable
private fun NavBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val items = listOf(
        Screen.Home,
        Screen.TaskList
    )

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    val currentRoute = currentDestination?.route

    NavigationBar(
        modifier = modifier,
        containerColor = Color.LightGray
    ) {

        items.forEachIndexed { index, screen ->

            NavigationBarItem(
                selected = currentRoute == screen.route,

                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                },
                icon = {
                    val icon = when (screen) {
                        Screen.Home -> Icons.Default.Home
                        Screen.TaskList -> Icons.Default.Task
                        Screen.TaskForm -> Icons.Default.PlayArrow
                    }
                    NavigationBarIcon(
                        icon = icon,
                        indicatorColor = Color.White,
                        isSelected = currentRoute == screen.route
                    )
                }
            )

        }
    }
}

@Composable
private fun NavigationBarIcon(
    isSelected: Boolean,
    icon: ImageVector,
    indicatorColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(35.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .offset(y = (-38).dp)
                    .background(indicatorColor)
            )
        }
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
    }
}