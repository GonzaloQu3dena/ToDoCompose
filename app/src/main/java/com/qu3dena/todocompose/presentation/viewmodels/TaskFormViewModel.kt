package com.qu3dena.todocompose.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

import com.qu3dena.todocompose.domain.entities.Task
import com.qu3dena.todocompose.domain.usecases.AddTaskUseCase
import com.qu3dena.todocompose.domain.usecases.UpdateTaskUseCase
import com.qu3dena.todocompose.presentation.ui.states.TaskUIState


class TaskFormViewModel(
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(TaskUIState())
    val state: StateFlow<TaskUIState> = _state.asStateFlow()

    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask: StateFlow<Task?> = _selectedTask.asStateFlow()

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
     * Adds or updates a task based on whether it has an ID.
     * @param task The task to be added or updated.
     */
    fun addOrUpdateTask(task: Task) {
        viewModelScope.launch {

            if (_selectedTask.value != null) {
                updateTaskUseCase.execute(task)

                _state.update {
                    val updatedTasks = it.tasks.map { t ->
                        if (t.id == task.id) task else t
                    }
                    it.copy(tasks = updatedTasks)
                }

                clearSelectedTask()
            }
            else {
                addTaskUseCase.execute(task)

                _state.update {
                    val updatedTasks = it.tasks + task
                    it.copy(tasks = updatedTasks)
                }
            }
        }
    }
}