package com.simpleworkoutservice.simpleworkoutservice.service.WorkoutService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleworkoutservice.simpleworkoutservice.dao.WorkoutRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;

@Service
public class WorkoutServiceImpl implements WorkoutService {

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
    public Workout findById(Long id) {
        Optional<Workout> result = workoutRepo.findById(id);

        Workout dbWorkout = null;
        if (result.isPresent()) {
            dbWorkout = result.get();
        } else {
            throw new RuntimeException("Did not find Workout id - " + id);
        }

        return dbWorkout;

    }

    @Override
    public Workout save(Workout Workout) {
        return workoutRepo.save(Workout);

    }

    @Override
    public Workout update(Long id, Workout Workout) {
        return workoutRepo.save(Workout);
    }

    @Override
    public void deleteById(Long id) {
        workoutRepo.deleteById(id);
    }

}
