package com.qu3dena.todocompose.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.ui.Modifier
import com.qu3dena.todocompose.presentation.PresentationModule

/**
 * HomeScreen is the main screen of the app.
 * It displays the task summary and allows the user to navigate to other screens.
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {

    val getTaskSummaryViewModel =  PresentationModule.getTaskSummaryViewModel()

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        TaskSummaryView(getTaskSummaryViewModel)
    }
}