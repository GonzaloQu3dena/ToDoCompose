package com.qu3dena.todocompose.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.qu3dena.todocompose.presentation.PresentationModule
import com.qu3dena.todocompose.presentation.viewmodels.TaskViewModel
import com.qu3dena.todocompose.shared.components.GenericFloatingActionButton

@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = PresentationModule.getTaskViewModel(),
    onNavigationToForm: () -> Unit,
) {

    val state = remember { mutableStateOf(viewModel.state.value) }

    LaunchedEffect(Unit) {
        viewModel.state.collect {
            state.value = it
        }
    }

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
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            elevation = CardDefaults.cardElevation()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = task.title, style = MaterialTheme.typography.titleMedium)
                                Text(text = task.description ?: "", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }
        }

        GenericFloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onClick = {
                onNavigationToForm()
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