package com.qu3dena.todocompose.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qu3dena.todocompose.domain.entities.Task

/**
 * Data Transfer Object (DTO) representing a task in the database.
 * @property id Unique identifier for the task.
 * @property title Short descriptive title of the task.
 * @property description Additional information about the task.
 * @property isCompleted Boolean indicating if the task is completed.
 */
@Entity(tableName = "tasks")
data class TaskDto(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
) {
    /**
     * Converts this TaskDto to a domain entity.
     * This function is used to convert the data transfer object to a domain entity.
     * @return Task object representing the task in the domain layer.
     */
    fun toDomain(): Task {
        return Task(id, title, description, isCompleted);
    }

    /**
     * Companion object for creating TaskDto instances.
     */
    companion object {
        /**
         * Creates a TaskDto from a domain Task object.
         * @param task The Task object to convert to a TaskDto.
         * @return TaskDto object representing the task in the data layer.
         */
        fun fromDomain(task: Task): TaskDto {
            return TaskDto(
                id = task.id,
                title = task.title,
                description = task.description ?: "",
                isCompleted = task.isCompleted
            )
        }
    }
}
