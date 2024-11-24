package com.example.spring_todo_list.exception.task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Exception thrown when a task is not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // Maps this exception to return a 404 status
public class TaskNotFoundException extends RuntimeException{
    /**
     * Constructor to create TaskNotFoundException
     * @param message The error message to be returned to the client.
     */
    public TaskNotFoundException(String message){
        super(message);
    }
}
