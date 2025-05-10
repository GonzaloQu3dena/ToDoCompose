package com.qu3dena.todocompose.domain.usecases

import com.qu3dena.todocompose.domain.entities.Task
import com.qu3dena.todocompose.domain.repository.ITaskRepository

/**
 * Use case for deleting a task.
 * This class encapsulates the logic for deleting a task from the repository.
 */
class DeleteTaskUseCase(private val taskRepository: ITaskRepository) {
    /**
     * Executes the use case to delete a task.
     * @param task The task to be deleted.
     */
    suspend fun execute(task: Task) {
        taskRepository.deleteTask(task)
    }
}