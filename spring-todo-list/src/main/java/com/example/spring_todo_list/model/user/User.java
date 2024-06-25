package com.example.spring_todo_list.model.user;

import jakarta.persistence.*;

/**
 * Entity class representing a user in the system.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // The primary key identifier for the user

    @Column(nullable = false, unique = true)
    private String username; // The username of the user. This field is unique and cannot be null.

    @Column(nullable = false)
    private String password; // The password of the user. This field cannot be null.

    public User(){}

    public User(String username, String password){
        this.username= username;
        this.password= password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
