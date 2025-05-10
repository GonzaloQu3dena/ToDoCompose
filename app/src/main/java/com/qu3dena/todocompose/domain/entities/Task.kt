package com.qu3dena.todocompose.domain.entities

import java.util.UUID

/**
 * Represents a task in the ToDo application.
 *
 * @property id Unique identifier for the task.
 * @property title Short descriptive title of the task.
 * @property description Additional information about the task.
 * @property isCompleted Boolean indicating if the task is completed.
 */
data class Task(
    val id: String = UUID
        .randomUUID().toString(),
    val title: String = "",
    val description: String? = null,
    val isCompleted: Boolean = false
)