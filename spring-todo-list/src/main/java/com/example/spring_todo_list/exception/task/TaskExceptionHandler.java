package com.example.spring_todo_list.exception.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global Exception Handler for handling application-wide exceptions.
 */
@RestControllerAdvice
public class TaskExceptionHandler {

    /**
     * Handles TaskNotFoundException and returns a 404 response.
     *
     * @param ex The TaskNotFoundException object.
     * @return A ResponseEntity with the exception message and 404 status.
     */
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleTaskNotFound(TaskNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    /**
     * Handles general exceptions and returns a 500 response.
     *
     * @param ex The Exception object.
     * @return A ResponseEntity with a generic error message and 500 status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex){
        return new ResponseEntity<>("An expected error occurred: "+ ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
