package com.qu3dena.todocompose.presentation

import com.qu3dena.todocompose.data.DataModule
import com.qu3dena.todocompose.domain.usecases.AddTaskUseCase
import com.qu3dena.todocompose.domain.usecases.DeleteTaskUseCase
import com.qu3dena.todocompose.domain.usecases.GetTasksUseCase
import com.qu3dena.todocompose.domain.usecases.UpdateTaskUseCase
import com.qu3dena.todocompose.presentation.viewmodels.TaskViewModel

/**
 * Module for providing dependencies related to the presentation layer.
 * This module is responsible for creating and providing instances of ViewModels and other presentation-related components.
 */
object PresentationModule {

    /**
     * Provides an instance of TaskViewModel.
     * This method creates a new instance of TaskViewModel and injects the necessary use cases.
     * @return An instance of TaskViewModel configured with the required use cases.
     */
    fun getTaskViewModel(): TaskViewModel {

        val taskRepository = DataModule.getTaskRepository()

        return TaskViewModel(
            addTaskUseCase = AddTaskUseCase(taskRepository),
            getTasksUseCase = GetTasksUseCase(taskRepository),
            deleteTaskUseCase = DeleteTaskUseCase(taskRepository),
            updateTaskUseCase = UpdateTaskUseCase(taskRepository)
        )
    }
}