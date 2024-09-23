package com.example.spring_todo_list.controller;

import com.example.spring_todo_list.model.user.User;
import com.example.spring_todo_list.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Controller for handling user registration and login.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Display the registration form.
     *
     * @param model Model to hold the user object
     * @return registration form view name
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Handle user registration.
     *
     * @param user User object containing registration data
     * @param bindingResult BindingResult to hold validation errors
     * @param model Model to hold the user object
     * @return redirect to home page if successful, otherwise return registration form view
     */
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.register(user);
        return "redirect:/home";
    }

    /**
     * Display the login form.
     *
     * @return login form view name
     */
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}