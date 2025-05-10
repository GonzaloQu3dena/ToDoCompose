package com.qu3dena.todocompose.domain.repository

import com.qu3dena.todocompose.domain.entities.Task
import kotlinx.coroutines.flow.Flow

/**
 * Interface for Task Repository that defines the contract for task-related operations.
 */
interface ITaskRepository {
    /**
     * Adds a new task to the repository.
     * @param task The task to be added.
     */
    suspend fun addTask(task: Task)
    /**
     * Updates an existing task in the repository.
     * @param task The task to be updated.
     */
    suspend fun updateTask(task: Task)
    /**
     * Deletes a task from the repository.
     * @param task The task to be deleted.
     */
    suspend fun deleteTask(task: Task)
    /**
     * Gets all tasks from the repository.
     * @return A flow of a list of tasks.
     */
    fun getAllTasks(): Flow<List<Task>>
    /**
     * Retrieves a task by its ID.
     * @param id The ID of the task to be retrieved.
     * @return A flow of the task with the specified ID.
     */
    fun getTaskById(id: String): Flow<Task>
}