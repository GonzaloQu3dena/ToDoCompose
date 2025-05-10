package com.qu3dena.todocompose

import android.app.Application

/**
 * Custom application class for the ToDoCompose application.
 * This class is used to initialize global application state.
 */
class ToDoApplication : Application() {
    /**
     * Singleton instance of the ToDoApplication.
     * This instance is used to access application context globally.
     */
    companion object {
        lateinit var instance: ToDoApplication
            private set
    }
    /**
     * Called when the application is created.
     * This method initializes the singleton instance of the application.
     */
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}