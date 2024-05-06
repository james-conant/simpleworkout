package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;
import com.simpleworkoutservice.simpleworkoutservice.service.WorkoutService.WorkoutService;
import java.util.List;

@RestController
@RequestMapping("/api/workout")
public class WorkoutsController {

    private WorkoutService workoutService;

    @Autowired
    public WorkoutsController(WorkoutService workoutService) {
        this.workoutService = workoutService;

    }

    // Add check if userId matches. Eventually we need roles
    @PostMapping
    public Workout createWorkout(@RequestBody Workout newWorkout) {
        return workoutService.save(newWorkout);
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.findAll();
    }

    @GetMapping("/{id}")
    public Workout getWorkout(@PathVariable Long id) {
        return workoutService.findById(id);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id, @RequestBody Workout updatedWorkout) {
        return workoutService.update(id, updatedWorkout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteById(id);
    }

}
