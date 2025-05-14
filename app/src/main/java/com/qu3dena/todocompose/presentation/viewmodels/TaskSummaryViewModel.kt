package com.qu3dena.todocompose.presentation.viewmodels

import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

import com.qu3dena.todocompose.domain.usecases.GetTasksUseCase
import com.qu3dena.todocompose.presentation.ui.states.TaskUIState

class TaskSummaryViewModel(
    private val getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(TaskUIState())
    val state: StateFlow<TaskUIState> = _state.asStateFlow()

    init {
        loadTasks()
    }

    /**
     * Loads tasks using the provided use case.
     */
    fun loadTasks() {
        viewModelScope.launch {
            getTasksUseCase.execute()
                .onStart { _state.value = _state.value.copy(isLoading = true) }
                .catch { error -> _state.value = _state.value.copy(error = error.message) }
                .collect { tasks -> _state.value = _state.value.copy(tasks = tasks, isLoading = false) }
        }
    }
}