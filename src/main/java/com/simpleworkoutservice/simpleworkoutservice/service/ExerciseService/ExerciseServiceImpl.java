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
    public Exercise findById(Long id) {
        Optional<Exercise> result = exerciseRepo.findById(id);

        Exercise dbExercise = null;
        if (result.isPresent()) {
            dbExercise = result.get();
        } else {
            throw new RuntimeException("Did not find Exercise id - " + id);
        }

        return dbExercise;

    }

    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepo.save(exercise);

    }

    @Override
    public Exercise update(Long id, Exercise exercise) {
        return exerciseRepo.save(exercise);
    }

    @Override
    public void deleteById(Long id) {
        exerciseRepo.deleteById(id);
    }

}
