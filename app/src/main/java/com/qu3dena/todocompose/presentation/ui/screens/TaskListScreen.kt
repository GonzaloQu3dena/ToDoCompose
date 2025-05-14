package com.qu3dena.todocompose.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import com.qu3dena.todocompose.domain.entities.Task

import com.qu3dena.todocompose.presentation.viewmodels.TaskListViewModel
import com.qu3dena.todocompose.shared.components.GenericFloatingActionButton

@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskListViewModel,
    onAddTask: () -> Unit,
    onEditTask: (Task) -> Unit
) {

    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
       viewModel.loadTasks()
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (state.value.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (state.value.error != null) {
                Text(
                    text = "Error: ${state.value.error}",
                    color = MaterialTheme.colorScheme.error
                )
            } else {
                LazyColumn {
                    items(state.value.tasks) { task ->
                        TaskItemView(
                            task = task,
                            onEdit = { onEditTask(task) },
                            onDelete = { viewModel.deleteTask(task) },
                            onToggleCompleted = { viewModel.toggleTaskCompleted(task) }
                        )
                    }
                }
            }
        }

        GenericFloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onClick = {
                onAddTask()
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        )
    }
}

@Composable
fun TaskItemView(
    task: Task,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onToggleCompleted: (Task) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Checkbox(
                    checked = task.isCompleted,
                    onCheckedChange = { onToggleCompleted(task) }
                )
            }

            Text(text = task.description ?: "", style = MaterialTheme.typography.bodyMedium)

            Box {
                Row {
                    IconButton(
                        onClick = {
                            onEdit()
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Task"
                        )
                    }

                    IconButton(
                        onClick = {
                            onDelete()
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete Task"
                        )
                    }
                }
            }
        }
    }
}