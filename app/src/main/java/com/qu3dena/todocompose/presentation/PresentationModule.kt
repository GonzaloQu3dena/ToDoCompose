package com.qu3dena.todocompose.presentation

import com.qu3dena.todocompose.data.DataModule
import com.qu3dena.todocompose.domain.usecases.AddTaskUseCase
import com.qu3dena.todocompose.domain.usecases.GetTasksUseCase
import com.qu3dena.todocompose.domain.usecases.DeleteTaskUseCase
import com.qu3dena.todocompose.domain.usecases.UpdateTaskUseCase
import com.qu3dena.todocompose.presentation.viewmodels.TaskFormViewModel
import com.qu3dena.todocompose.presentation.viewmodels.TaskListViewModel
import com.qu3dena.todocompose.presentation.viewmodels.TaskSummaryViewModel

/**
 * Module for providing dependencies related to the presentation layer.
 * This module is responsible for creating and providing instances of ViewModels and other presentation-related components.
 */
object PresentationModule {

    /**
     * Provides an instance of [TaskListViewModel].
     * This ViewModel is responsible for managing the task list and handling user interactions related to tasks.
     * It uses the [GetTasksUseCase] to retrieve tasks and the [DeleteTaskUseCase] to delete tasks.
     * @return An instance of [TaskListViewModel].
     */
    fun getTaskListViewModel(): TaskListViewModel {

        val taskRepository = DataModule.getTaskRepository()

        return TaskListViewModel(
            getTasksUseCase = GetTasksUseCase(taskRepository),
            deleteTaskUseCase = DeleteTaskUseCase(taskRepository),
            updateTaskUseCase = UpdateTaskUseCase(taskRepository)
        )
    }

    /**
     * Provides an instance of [TaskFormViewModel].
     * This ViewModel is responsible for managing the task form and handling user interactions related to adding or updating tasks.
     * It uses the [AddTaskUseCase] to add new tasks and the [UpdateTaskUseCase] to update existing tasks.
     * @return An instance of [TaskFormViewModel].
     */
    fun getTaskFormViewModel(): TaskFormViewModel {

        val taskRepository = DataModule.getTaskRepository()

        return TaskFormViewModel(
            addTaskUseCase = AddTaskUseCase(taskRepository),
            updateTaskUseCase = UpdateTaskUseCase(taskRepository)
        )
    }

    /**
     * Provides an instance of [TaskSummaryViewModel].
     * This ViewModel is responsible for managing the task summary and handling user interactions related to viewing task summaries.
     * It uses the [GetTasksUseCase] to retrieve tasks.
     * @return An instance of [TaskSummaryViewModel].
     */
    fun getTaskSummaryViewModel(): TaskSummaryViewModel {
        val taskRepository = DataModule.getTaskRepository()

        return TaskSummaryViewModel(
            getTasksUseCase = GetTasksUseCase(taskRepository)
        )
    }
}