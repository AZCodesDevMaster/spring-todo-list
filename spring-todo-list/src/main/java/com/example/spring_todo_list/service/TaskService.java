package com.example.spring_todo_list.service;

import com.example.spring_todo_list.model.Task;
import com.example.spring_todo_list.model.TaskStatusType;
import com.example.spring_todo_list.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing tasks in the ToDo list application.
 * This class contains business logic related to tasks and interacts with the data layer.
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Retrieves a list of all tasks.
     *
     * @return A list of all tasks.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Retrieves a task by its unique identifier.
     *
     * @param taskId The unique identifier of the task.
     * @return The task object with the specified identifier, or null if not found.
     */
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    /**
     * Retrieves a list of tasks with a specific status.
     *
     * @param status The status to filter tasks.
     * @return A list of tasks with the specified status.
     */
    public List<Task> findByStatus(TaskStatusType status) {
        return taskRepository.findByTaskStatus(status);
    }

    /**
     * Creates a new task.
     *
     * @param task The task object to be created.
     * @return The created task object.
     */
    public Task createTask(Task task) {
        task.setTaskCreatedAt(java.time.LocalDateTime.now());
        task.setTaskUpdatedAt(java.time.LocalDateTime.now());
        return taskRepository.save(task);
    }

    /**
     * Updates an existing task.
     *
     * @param taskId      The unique identifier of the task to be updated.
     * @param updatedTask The updated task data.
     * @return The updated task object, or null if the task with the given ID is not found.
     */
    public Task updateTask(Long taskId, Task updatedTask) {
        Task existingTask = taskRepository.findById(taskId).orElse(null);
        if (existingTask != null) {
            existingTask.setTaskTitle(updatedTask.getTaskTitle());
            existingTask.setTaskDescription(updatedTask.getTaskDescription());
            existingTask.setTaskDueDate(updatedTask.getTaskDueDate());
            existingTask.setTaskStatus(updatedTask.getTaskStatus());
            existingTask.setTaskUpdatedAt(java.time.LocalDateTime.now());
            return taskRepository.save(existingTask);
        }
        return null; // or throw an exception if task not found
    }

    /**
     * Deletes a task by its unique identifier.
     *
     * @param taskId The unique identifier of the task to be deleted.
     */
    public boolean deleteTask(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);

        if (optionalTask.isPresent()) {
            taskRepository.deleteById(taskId);
            return true; // Deletion successful
        } else {
            return false; // Task with the given ID not found
        }
    }
}