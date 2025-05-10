package com.qu3dena.todocompose.data

import androidx.room.Room
import com.qu3dena.todocompose.ToDoApplication
import com.qu3dena.todocompose.data.local.dao.TaskDao
import com.qu3dena.todocompose.data.repository.TaskRepository
import com.qu3dena.todocompose.data.local.database.AppDatabase
import com.qu3dena.todocompose.data.local.datasource.TaskLocalDataSource

/**
 * DataModule is a singleton object that provides instances of the database, DAO, local data source, and repository.
 * This module is responsible for managing the data layer of the application.
 */
object DataModule {
    /**
     * Provides an instance of the AppDatabase.
     * This method creates a Room database instance using the application context.
     * @return An instance of AppDatabase.
     */
    fun getAppDataBase(): AppDatabase {
        return Room.databaseBuilder(
            ToDoApplication.instance.applicationContext,
            AppDatabase::class.java, AppDatabase.DATABASE_NAME
        ).build()
    }
    /**
     * Provides an instance of the TaskDao.
     * This method retrieves the TaskDao from the AppDatabase instance.
     * @return An instance of TaskDao.
     */
    fun getTaskDao(): TaskDao {
        return getAppDataBase().taskDao()
    }
    /**
     * Provides an instance of the TaskLocalDataSource.
     * This method creates a TaskLocalDataSource using the TaskDao instance.
     * @return An instance of TaskLocalDataSource.
     */
    fun getTaskLocalDataSource(): TaskLocalDataSource {
        return TaskLocalDataSource(getTaskDao())
    }
    /**
     * Provides an instance of the TaskRepository.
     * This method creates a TaskRepository using the TaskLocalDataSource instance.
     * @return An instance of TaskRepository.
     */
    fun getTaskRepository(): TaskRepository {
        return TaskRepository(getTaskLocalDataSource())
    }
}