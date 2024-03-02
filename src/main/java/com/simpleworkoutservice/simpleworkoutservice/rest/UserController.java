package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;
import com.simpleworkoutservice.simpleworkoutservice.service.ExerciseService.ExerciseService;
import com.simpleworkoutservice.simpleworkoutservice.service.UserService.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    ExerciseService exerciseService;

    @Autowired
    public UserController(UserService userService,
            ExerciseService exerciseService) {
        this.userService = userService;
        this.exerciseService = exerciseService;

    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {

        User user = userService.findById(id);

        if (user == null) {
            throw new RuntimeException("User id not found - " + id);
        }

        return user;
    }

    @GetMapping("/users/username/{name}")
    public User findByUsername(@PathVariable("name") String name) {
        return userService.findByUsername(name);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        User dbUser = userService.save(user);
        return dbUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        User dbUser = userService.save(user);

        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {

        User dbUser = userService.findById(userId);
        if (dbUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);

        return "Deleted user id - " + userId;
    }

}
