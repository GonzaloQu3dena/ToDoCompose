package com.qu3dena.todocompose

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.qu3dena.todocompose.presentation.ui.screens.MainScreen
import com.qu3dena.todocompose.presentation.ui.theme.ToDoComposeTheme

/**
 * Main activity for the ToDoCompose application.
 */
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    /**
     * Called when the activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ToDoComposeTheme {
                navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }
}