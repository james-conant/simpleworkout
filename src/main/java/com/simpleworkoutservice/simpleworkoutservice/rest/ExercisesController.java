package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;
import com.simpleworkoutservice.simpleworkoutservice.service.ExerciseService.ExerciseService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExercisesController {

    ExerciseService exerciseService;

    @Autowired
    public ExercisesController(
            ExerciseService exerciseService) {
        this.exerciseService = exerciseService;

    }

    // @GetMapping("/exercises/{id}")
    // public List<Exercise> getExercisesByWorkout(@PathVariable("id") int id,
    // @RequestHeader("userId") int userId) {

    // List<Exercise> exercises = exerciseService.findAllByWorkoutId(id);

    // if (exercises == null) {
    // throw new RuntimeException("excercise id not found - " + id);
    // }

    // return exercises;
    // }

}
