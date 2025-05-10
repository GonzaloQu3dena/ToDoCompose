package com.qu3dena.todocompose.domain.usecases

import com.qu3dena.todocompose.domain.entities.Task
import com.qu3dena.todocompose.domain.repository.ITaskRepository

/**
 * Use case for adding a task.
 * This class encapsulates the logic for adding a task to the repository.
 */
class AddTaskUseCase(private val taskRepository: ITaskRepository) {
    /**
     * Executes the use case to add a task.
     */
    suspend fun execute(task: Task) {
        taskRepository.addTask(task)
    }
}