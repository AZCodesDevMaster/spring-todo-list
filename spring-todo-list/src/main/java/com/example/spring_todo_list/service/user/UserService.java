package com.example.spring_todo_list.service.user;

import com.example.spring_todo_list.model.user.User;
import com.example.spring_todo_list.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for managing user-related operations.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * Registers a new user by encoding their password and saving them to the database.
     * @param user the user to be registered.
     * @return the registered user.
     */
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Finds a user by their username.
     * @param username the username of the user.
     * @return the found user or null if no user found.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
