package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;
import com.simpleworkoutservice.simpleworkoutservice.service.ExerciseService.ExerciseService;
import com.simpleworkoutservice.simpleworkoutservice.service.UserService.UserService;
import com.simpleworkoutservice.simpleworkoutservice.service.WorkoutService.WorkoutService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkoutsController {

    private WorkoutService workoutService;
    ExerciseService exerciseService;

    @Autowired
    public WorkoutsController(WorkoutService workoutService) {
        this.workoutService = workoutService;

    }

    @GetMapping("/workouts/{workoutId}")
    public Workout getWorkoutById(@PathVariable("workoutId") int workoutId) {

        Workout workout = workoutService.findById(workoutId);

        if (workout == null) {
            throw new RuntimeException("workout id not found - " + workout);
        }

        return workout;
    }

}
