package com.qu3dena.todocompose

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.qu3dena.todocompose.presentation.navigation.NavGraph
import com.qu3dena.todocompose.presentation.ui.screens.MainScreen
import com.qu3dena.todocompose.presentation.ui.theme.ToDoComposeTheme

/**
 * Main activity for the ToDoCompose application.
 */
class MainActivity : ComponentActivity() {

    /**
     * Called when the activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ToDoComposeTheme {
                val navController = rememberNavController()

                MainScreen(navController) { modifier ->
                    NavGraph(navController = navController, modifier = modifier)
                }

            }
        }
    }
}