package com.example.spring_todo_list.controller.task;

import com.example.spring_todo_list.model.task.Task;
import com.example.spring_todo_list.model.task.TaskStatusType;
import com.example.spring_todo_list.service.task.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final TaskService taskService;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Retrieves a list of all tasks.
     *
     * @return A list of all tasks
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        logger.info("fetching all tasks");
        List<Task> tasks = taskService.getAllTasks();
        logger.debug("Number of tasks retrieved: {}", tasks.size());
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
        logger.info("Fetching task with ID :{}", taskId);
        Task task = taskService.getTaskByTaskId(taskId); // Throws TaskNotFoundException if not found
        logger.info("Task found: {}", task.getTaskTitle());
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    /**
     * Creates a new task.
     *
     * @param task The task object to be created.
     * @return The created task object.
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        logger.info("Creating a new task: {}", task.getTaskTitle());
        Task createdTask = taskService.createTask(task);
        logger.info("Task created with ID: {}", createdTask.getTaskId());
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
        logger.info("Updating task with ID: {}", taskId);
        Task updatedTask = taskService.updateTask(taskId, task);
        logger.info("Task with ID {} updated successfully", taskId);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
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
        logger.info("Fetching tasks with status: {}", taskStatus);
        List<Task> tasks = taskService.findByTaskStatus(taskStatus);
        logger.debug("Number of tasks with status {}: {}", taskStatus, tasks.size());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}