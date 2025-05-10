package com.qu3dena.todocompose.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Update

import kotlinx.coroutines.flow.Flow

import com.qu3dena.todocompose.data.dto.TaskDto

/**
 * Data Access Object (DAO) for managing tasks in the database.
 * This interface defines methods for inserting, updating, deleting, and querying tasks.
 */
@Dao
interface TaskDao {
    /**
     * Inserts a new task into the database.
     * @param task The task to be inserted.
     */
    @Insert
    suspend fun insert(task: TaskDto)

    /**
     * Updates an existing task in the database.
     * @param task The task to be updated.
     */
    @Update
    suspend fun update(task: TaskDto)

    /**
     * Deletes a task from the database.
     * @param task The task to be deleted.
     */
    @Delete
    suspend fun delete(task: TaskDto)

    /**
     * Retrieves all tasks from the database.
     * @return A flow of a list of tasks.
     */
    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<TaskDto>>

    /**
     * Retrieves a task by its ID.
     * @param id The ID of the task to be retrieved.
     * @return A flow of the task with the specified ID.
     */
    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getById(id: String): Flow<TaskDto>
}