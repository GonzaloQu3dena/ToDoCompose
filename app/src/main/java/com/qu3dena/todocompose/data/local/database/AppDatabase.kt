package com.qu3dena.todocompose.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qu3dena.todocompose.data.dto.TaskDto
import com.qu3dena.todocompose.data.local.dao.TaskDao

/**
 * Abstract class representing the Room database for the application.
 * This class contains the database configuration and serves as the main access point for the underlying SQLite database.
 */
@Database(entities = [TaskDto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Abstract method to get the TaskDao instance.
     */
    abstract fun taskDao(): TaskDao

    /**
     * Companion object for the AppDatabase class.
     * This object contains constants and static methods related to the database.
     */
    companion object {
        const val DATABASE_NAME = "task_db"
    }
}