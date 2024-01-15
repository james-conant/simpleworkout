package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleworkoutservice.simpleworkoutservice.dao.WorkoutRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;

@Service
public class WorkoutServiceImpl implements BaseService<Workout, Integer> {

    private WorkoutRepository workoutRepo;

    @Autowired
    public WorkoutServiceImpl(WorkoutRepository workoutRepo) {
        this.workoutRepo = workoutRepo;
    }

    @Override
    public List<Workout> findAll() {
        return workoutRepo.findAll();
    }

    @Override
    public Workout findById(int id) {

        Optional<Workout> result = workoutRepo.findById(id);

        Workout dbWorkout = null;

        if (result.isPresent()) {
            dbWorkout = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return dbWorkout;
    }

    @Override
    public Workout save(Workout user) {
        return workoutRepo.save(user);
    }

    @Override
    public void deleteById(int userId) {
        workoutRepo.deleteById(userId);
    }

}
