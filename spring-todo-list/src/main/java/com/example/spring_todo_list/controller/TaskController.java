package com.example.spring_todo_list.controller;

import com.example.spring_todo_list.model.Task;
import com.example.spring_todo_list.model.TaskStatusType;
import com.example.spring_todo_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  TaskController for managing tasks in the ToDo List application.
 *  This class handles HTTP request related to tasks.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Retrieves a list of all tasks.
     *
     * @return A list of all tasks
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    /**
     * Retrieves a task by its unique identifier
     *
     * @param taskId The unique identifier of the task.
     * @return The task object with the specified identifier.
     */
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        Task task = taskService.getTaskByTaskId(taskId);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates a new task.
     *
     * @param task The task object to be created.
     * @return The created task object.
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    /**
     * Updates an existing task.
     *
     * @param taskId  The unique identifier of the task to be updated
     * @param task The updated task data.
     * @return The updated task object.
     */
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable("taskId") Long taskId, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(taskId, task);
        if (updatedTask != null) {
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes a task by its unique identifier
     *
     * @param taskId The unique identifier of the task to be deleted
     */
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Long taskId) {
        boolean deleted = taskService.deleteTask(taskId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a list of tasks with a specific status.
     *
     * @param taskStatus The status to filter tasks.
     * @return A list of tasks with the specified status.
     */
    @GetMapping("/taskStatus/{taskStatus}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable("taskStatus") TaskStatusType taskStatus) {
        List<Task> tasks = taskService.findByTaskStatus(taskStatus);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}