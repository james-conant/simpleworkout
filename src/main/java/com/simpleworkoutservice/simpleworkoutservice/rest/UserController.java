package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;
import com.simpleworkoutservice.simpleworkoutservice.service.ExerciseService;
import com.simpleworkoutservice.simpleworkoutservice.service.UserService;
import com.simpleworkoutservice.simpleworkoutservice.service.WorkoutService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private WorkoutService workoutService;
    ExerciseService exerciseService;

    @Autowired
    public UserController(UserService userService, WorkoutService workoutService,
            ExerciseService exerciseService) {
        this.userService = userService;
        this.workoutService = workoutService;
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
    public User findByUserName(@PathVariable("name") String name) {
        return userService.findByUserName(name);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {

        user.setId(0);

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
