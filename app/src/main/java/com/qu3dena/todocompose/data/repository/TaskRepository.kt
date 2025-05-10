package com.qu3dena.todocompose.data.repository

import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

import com.qu3dena.todocompose.domain.entities.Task
import com.qu3dena.todocompose.domain.repository.ITaskRepository

import com.qu3dena.todocompose.data.dto.TaskDto
import com.qu3dena.todocompose.data.local.datasource.TaskLocalDataSource

/**
 * TaskRepository is responsible for managing tasks in the application.
 * This class interacts with the local data source to perform CRUD operations on tasks.
 */
class TaskRepository(private val taskLocalDataSource: TaskLocalDataSource) : ITaskRepository {
    /**
     * @see ITaskRepository.addTask
     */
    override suspend fun addTask(task: Task) {
        taskLocalDataSource.insert(TaskDto.fromDomain(task))
    }
    /**
     * @see ITaskRepository.updateTask
     */
    override suspend fun updateTask(task: Task) {
        taskLocalDataSource.update(TaskDto.fromDomain(task))
    }
    /**
     * @see ITaskRepository.deleteTask
     */
    override suspend fun deleteTask(task: Task) {
        taskLocalDataSource.delete(TaskDto.fromDomain(task))
    }
    /**
     * @see ITaskRepository.getAllTasks
     */
    override fun getAllTasks(): Flow<List<Task>> {
        return taskLocalDataSource.getAll().map { tasks ->
            tasks.map {
                it.toDomain()
            }
        }
    }
    /**
     * @see ITaskRepository.getTaskById
     */
    override fun getTaskById(id: String): Flow<Task> {
        return taskLocalDataSource.getById(id).map {
            it.toDomain()
        }
    }
}