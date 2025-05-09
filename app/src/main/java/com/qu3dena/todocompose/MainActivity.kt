package com.qu3dena.todocompose

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.qu3dena.todocompose.presentation.navigation.NavGraph
import com.qu3dena.todocompose.presentation.ui.screens.MainScreen
import com.qu3dena.todocompose.presentation.ui.theme.ToDoComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ToDoComposeTheme {
                val navController = rememberNavController()

                MainScreen { modifier ->
                    NavGraph(navController = navController, modifier = modifier)
                }

            }
        }
    }
}