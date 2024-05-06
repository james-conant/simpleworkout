package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;
import com.simpleworkoutservice.simpleworkoutservice.service.ExerciseService.ExerciseService;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExercisesController {

    ExerciseService exerciseService;

    @Autowired
    public ExercisesController(
            ExerciseService exerciseService) {
        this.exerciseService = exerciseService;

    }

    // Add check if userId matches. Eventually we need roles
    @PostMapping
    public Exercise createExercise(@RequestBody Exercise newExercise) {
        return exerciseService.save(newExercise);
    }

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseService.findAll();
    }

    @GetMapping("/{id}")
    public Exercise getExercise(@PathVariable Long id) {
        return exerciseService.findById(id);
    }

    @PutMapping("/{id}")
    public Exercise updateExercise(@PathVariable Long id, @RequestBody Exercise updatedExercise) {
        return exerciseService.update(id, updatedExercise);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteById(id);
    }

}
