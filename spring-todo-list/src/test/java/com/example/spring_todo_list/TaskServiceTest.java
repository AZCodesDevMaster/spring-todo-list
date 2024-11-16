package com.example.spring_todo_list;

import com.example.spring_todo_list.model.task.Task;
import com.example.spring_todo_list.model.task.TaskStatusType;
import com.example.spring_todo_list.repository.task.TaskRepository;
import com.example.spring_todo_list.service.task.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    void testDatabaseConnection() {
        assertThat(taskRepository).isNotNull();
    }

    @Test
    void testCreateTask() {
        Task task = new Task("Test Task", "Test Description", LocalDateTime.now().plusDays(1), TaskStatusType.PENDING);
        Task createdTask = taskService.createTask(task);

        assertThat(createdTask).isNotNull();
        assertThat(createdTask.getTaskId()).isNotNull();
        assertThat(createdTask.getTaskTitle()).isEqualTo("Test Task");
    }

    @Test
    void testGetAllTasks() {
        Task task1 = new Task("Test Task 1", "Test Description 1", LocalDateTime.now().plusDays(1), TaskStatusType.PENDING);
        Task task2 = new Task("Test Task 2", "Test Description 2", LocalDateTime.now().plusDays(2), TaskStatusType.COMPLETED);
        taskService.createTask(task1);
        taskService.createTask(task2);

        List<Task> tasks = taskService.getAllTasks();
        assertThat(tasks).hasSize(2);
    }

    @Test
    void testGetTaskById() {
        Task task = new Task("Test Task", "Test Description", LocalDateTime.now().plusDays(1), TaskStatusType.PENDING);
        Task createdTask = taskService.createTask(task);

        Task foundTask = taskService.getTaskByTaskId(createdTask.getTaskId());
        assertThat(foundTask).isNotNull();
        assertThat(foundTask.getTaskTitle()).isEqualTo("Test Task");
    }

    @Test
    void testUpdateTask() {
        Task task = new Task("Test Task", "Test Description", LocalDateTime.now().plusDays(1), TaskStatusType.PENDING);
        Task createdTask = taskService.createTask(task);

        createdTask.setTaskTitle("Updated Task Title");
        Task updatedTask = taskService.updateTask(createdTask.getTaskId(), createdTask);

        assertThat(updatedTask).isNotNull();
        assertThat(updatedTask.getTaskTitle()).isEqualTo("Updated Task Title");
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("Test Task", "Test Description", LocalDateTime.now().plusDays(1), TaskStatusType.PENDING);
        Task createdTask = taskService.createTask(task);

        boolean isDeleted = taskService.deleteTask(createdTask.getTaskId());
        assertThat(isDeleted).isTrue();
        assertThat(taskRepository.findById(createdTask.getTaskId())).isEmpty();
    }
}
