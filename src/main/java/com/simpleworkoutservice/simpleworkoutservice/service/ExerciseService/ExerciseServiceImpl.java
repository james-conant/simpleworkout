package com.simpleworkoutservice.simpleworkoutservice.service.ExerciseService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpleworkoutservice.simpleworkoutservice.dao.ExerciseRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepo;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepo.findAll();
    }

    @Override
    public Exercise findById(int id) {

        Optional<Exercise> result = exerciseRepo.findById(id);

        Exercise dbExercise = null;

        if (result.isPresent()) {
            dbExercise = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find exercise id - " + id);
        }

        return dbExercise;
    }

    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepo.save(exercise);
    }

    @Override
    public void deleteById(int exerciseId) {
        exerciseRepo.deleteById(exerciseId);
    }

    @Override
    public List<Exercise> findAllByWorkoutId(int id) {
        return exerciseRepo.findAllByWorkoutId(id);

    }

}
