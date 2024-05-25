package com.example.spring_todo_list.model;

import java.time.LocalDateTime;

public class Task {

    private Long taskId;
    private String taskTitle;
    private String taskDescription;
    private LocalDateTime taskCreatedAt;
    private LocalDateTime taskUpdatedAt;
    private LocalDateTime taskDueDate;
    private TaskStatusType taskStatus;

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
