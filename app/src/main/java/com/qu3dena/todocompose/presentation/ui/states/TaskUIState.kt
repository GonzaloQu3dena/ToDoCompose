package com.qu3dena.todocompose.presentation.ui.states

import com.qu3dena.todocompose.domain.entities.Task

/**
 * UI state for the TaskViewModel.
 * This class represents the state of the UI, including error messages, loading status, and the list of tasks.
 * @property error An optional error message.
 * @property isLoading A boolean indicating whether the UI is loading.
 * @property tasks A list of tasks.
 */
data class TaskUIState(
    val error: String? = null,
    val isLoading: Boolean = false,
    val tasks: List<Task> = emptyList()
)