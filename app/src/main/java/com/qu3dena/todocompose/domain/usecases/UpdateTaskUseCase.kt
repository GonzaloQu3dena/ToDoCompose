package com.qu3dena.todocompose.domain.usecases

import com.qu3dena.todocompose.domain.entities.Task
import com.qu3dena.todocompose.domain.repository.ITaskRepository

/**
 * Use case for updating a task.
 * This class encapsulates the logic for updating a task in the repository.
 */
class UpdateTaskUseCase(private val taskRepository: ITaskRepository) {
    /**
     * Executes the use case to update a task.
     */
    suspend fun execute(task: Task) {
        taskRepository.updateTask(task)
    }
}