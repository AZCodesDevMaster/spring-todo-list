package com.example.spring_todo_list.model.task;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Represents a task in the ToDo List application.
 */
@Entity
@Table(name= "tasks")
public class Task {

    // Fields representing various aspects of a task
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId; // Unique identifier for the task

    @NotNull(message = "Title cannot be null")
    @Size(min=3, max=50, message = "Title must be between 3 and 50 characters")
    private String taskTitle; // Title of the task

    @Size(max=500, message = "Description cannot exceed 500 characters")
    private String taskDescription; // Description of the task
    private LocalDateTime taskCreatedAt; // Date and time when the task was created
    private LocalDateTime taskUpdatedAt; // Date and time when the task was last updated
    private LocalDateTime taskDueDate; // Due date of the task

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status cannot be null")
    private TaskStatusType taskStatus; // Status of the task (e.g., Pending, In Progress, Completed)

    public Task() {
    }

    public Task(String taskTitle, String taskDescription, LocalDateTime taskDueDate, TaskStatusType taskStatus) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
        this.taskStatus = taskStatus;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getTaskCreatedAt() {
        return taskCreatedAt;
    }

    public void setTaskCreatedAt(LocalDateTime taskCreatedAt) {
        this.taskCreatedAt = taskCreatedAt;
    }

    public LocalDateTime getTaskUpdatedAt() {
        return taskUpdatedAt;
    }

    public void setTaskUpdatedAt(LocalDateTime taskUpdatedAt) {
        this.taskUpdatedAt = taskUpdatedAt;
    }

    public LocalDateTime getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(LocalDateTime taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public TaskStatusType getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatusType taskStatus) {
        this.taskStatus = taskStatus;
    }
}
