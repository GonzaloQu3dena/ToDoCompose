package com.qu3dena.todocompose.domain.usecases

import com.qu3dena.todocompose.domain.entities.Task
import com.qu3dena.todocompose.domain.repository.ITaskRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use case for retrieving all tasks.
 * This class encapsulates the logic for retrieving all tasks from the repository.
 */
class GetTasksUseCase(private val taskRepository: ITaskRepository) {
    /**
     * Executes the use case to retrieve all tasks.
     * @return A flow of a list of tasks.
     */
    fun execute(): Flow<List<Task>> {
        return taskRepository.getAllTasks()
    }
}