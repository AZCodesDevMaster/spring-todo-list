package com.example.spring_todo_list.repository.user;

import com.example.spring_todo_list.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * Repository interface for accessing User data from the database.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by their username.
     * @param username the username of the user.
     * @return an Optional containing the found user or empty if no user found.
     */
    Optional<User> findByUsername(String username);
}
