package com.qu3dena.todocompose.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

import com.qu3dena.todocompose.presentation.viewmodels.TaskSummaryViewModel

@Composable
fun TaskSummaryView(
    viewModel: TaskSummaryViewModel
) {
    val state = viewModel.state.collectAsState()

    val totalTasks = state.value.tasks.size
    val totalCompletedTasks = state.value.tasks.filter { task ->
        task.isCompleted
    }.size

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            Box {
                Row (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TaskSummaryItemView(summaryTitle = "Total Tasks", summaryValue = totalTasks.toString())
                    TaskSummaryItemView(summaryTitle = "Completed Tasks", summaryValue = totalCompletedTasks.toString())
                }
            }
        }
    }
}

@Composable
fun TaskSummaryItemView(
    summaryTitle: String = "_",
    summaryValue: String = "0",
) {
    Card(
        modifier = Modifier
            .width(165.dp)
            .height(140.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = summaryTitle,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700)
                )

                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )

                Text(
                    text = summaryValue,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(300)
                )
            }
        }
    }
}