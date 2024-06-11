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
    public Optional<Task> findById(Long taskId);

    /**
     * Retrieves tasks by title.
     *
     * @param title The title to filter tasks.
     * @return A list of tasks with the specified title.
     */
    List<Task> findByTitle(String title);

    /**
     * Retrieves tasks by status.
     *
     * @param status The status to filter tasks.
     * @return A list of tasks with the specified status.
     */
    List<Task> findByStatus(TaskStatusType status);

    /**
     * Retrieves tasks with due dates before the given date.
     *
     * @param dueDate The due date to filter tasks.
     * @return A list of tasks with due dates before the specified date.
     */
    List<Task> findByDueDateBefore(LocalDate dueDate);

    /**
     * Retrieves tasks with titles containing the specified keyword.
     *
     * @param keyWord The keyword to search for in task titles.
     * @return A list of tasks with titles containing the specified keyword.
     */
    List<Task> findByTitleContaining(String keyWord);

    /**
     * Retrieves tasks with descriptions containing the specified keyword.
     *
     * @param keyWord The keyword to search for in task descriptions.
     * @return A list of tasks with descriptions containing the specified keyword.
     */
    List<Task> findByDescriptionContaining(String keyWord);

    List<Task> findByTaskStatus(TaskStatusType status);
}