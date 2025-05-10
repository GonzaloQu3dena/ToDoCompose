package com.qu3dena.todocompose.domain.usecases

import com.qu3dena.todocompose.domain.entities.Task
import com.qu3dena.todocompose.domain.repository.ITaskRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use case for retrieving all tasks.
 * This class encapsulates the logic for retrieving all tasks from the repository.
 */
class GetTaskByIdUseCase(private val taskRepository: ITaskRepository) {
    /**
     * Executes the use case to retrieve a task by its ID.
     * @return A flow of the task with the specified ID.
     */
    fun execute(taskId: String): Flow<Task>  {
        return taskRepository.getTaskById(taskId)
    }
}