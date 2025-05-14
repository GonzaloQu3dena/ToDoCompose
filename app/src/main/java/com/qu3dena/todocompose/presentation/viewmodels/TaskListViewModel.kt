package com.qu3dena.todocompose.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

import com.qu3dena.todocompose.domain.entities.Task
import com.qu3dena.todocompose.domain.usecases.GetTasksUseCase
import com.qu3dena.todocompose.domain.usecases.DeleteTaskUseCase
import com.qu3dena.todocompose.presentation.ui.states.TaskUIState

/**
 * ViewModel for managing tasks.
 * This class encapsulates the logic for adding, retrieving, deleting, and updating tasks.
 * @param getTasksUseCase Use case for retrieving tasks.
 * @param deleteTaskUseCase Use case for deleting a task.
 */
class TaskListViewModel(
    private val getTasksUseCase: GetTasksUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(TaskUIState())
    val state: StateFlow<TaskUIState> = _state.asStateFlow()

    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask: StateFlow<Task?> = _selectedTask.asStateFlow()

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
    /**
     * Selects a task to be edited or viewed.
     * @param task The task to be selected.
     */
    fun selectTask(task: Task) {
        _selectedTask.value = task
    }
    /**
     * Clears the selected task.
     */
    fun clearSelectedTask() {
        _selectedTask.value = null
    }
    /**
     * Deletes a task using the provided use case.
     * @param task The task to be deleted.
     */
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase.execute(task)

            _state.update {
                val updatedTasks = it.tasks.filter {
                    t -> t.id != task.id
                }

                it.copy(tasks = updatedTasks);
            }
        }
    }
}