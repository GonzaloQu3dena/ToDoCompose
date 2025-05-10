package com.qu3dena.todocompose.data.local.datasource

import kotlinx.coroutines.flow.Flow
import com.qu3dena.todocompose.data.dto.TaskDto
import com.qu3dena.todocompose.data.local.dao.TaskDao

/**
 * Service class for managing tasks in the database.
 * This class provides methods to insert, update, delete, and retrieve tasks.
 */
class TaskLocalDataSource(private val dao: TaskDao) {
    /**
     * Inserts a new task into the database.
     * @param task The task to be inserted.
     */
    suspend fun insert(task: TaskDto) {
        dao.insert(task)
    }
    /**
     * Updates an existing task in the database.
     * @param task The task to be updated.
     */
    suspend fun update(task: TaskDto) {
        dao.update(task)
    }
    /**
     * Deletes a task from the database.
     * @param task The task to be deleted.
     */
    suspend fun delete(task: TaskDto) {
        dao.delete(task)
    }
    /**
     * Retrieves all tasks from the database.
     * @return A flow of a list of tasks.
     */
    fun getAll(): Flow<List<TaskDto>> {
        return dao.getAll()
    }
    /**
     * Retrieves a task by its ID.
     * @param id The ID of the task to be retrieved.
     * @return A flow of the task with the specified ID.
     */
    fun getById(id: String): Flow<TaskDto> {
        return dao.getById(id)
    }
}