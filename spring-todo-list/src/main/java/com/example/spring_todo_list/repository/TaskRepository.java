package com.example.spring_todo_list.repository;

import com.example.spring_todo_list.model.Task;
import com.example.spring_todo_list.model.TaskStatusType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Task entities.
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    /**
     * Retrieves all tasks.
     *
     * @return A list of all tasks.
     */
    List<Task> findAll();

    /**
     * Retrieves a task by its unique identifier.
     *
     * @param taskId The unique identifier of the task.
     * @return An Optional containing the task with the specified identifier, or empty if not found.
     */
    public Optional<Task> findByTaskId(Long taskId);

    /**
     * Retrieves tasks by title.
     *
     * @param taskTitle The title to filter tasks.
     * @return A list of tasks with the specified title.
     */
    List<Task> findByTaskTitle(String taskTitle);

    /**
     * Retrieves tasks by status.
     *
     * @param taskStatus The status to filter tasks.
     * @return A list of tasks with the specified status.
     */
    List<Task> findByTaskStatus(TaskStatusType taskStatus);

    /**
     * Retrieves tasks with due dates before the given date.
     *
     * @param taskDueDate The due date to filter tasks.
     * @return A list of tasks with due dates before the specified date.
     */
    List<Task> findByTaskDueDateBefore(LocalDate taskDueDate);

    /**
     * Retrieves tasks with titles containing the specified keyword.
     *
     * @param taskTitle The keyword to search for in task titles.
     * @return A list of tasks with titles containing the specified keyword.
     */
    List<Task> findByTaskTitleContaining(String taskTitle);

}