package com.simpleworkoutservice.simpleworkoutservice.service.ExerciseService;

import java.util.List;

import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;
import com.simpleworkoutservice.simpleworkoutservice.service.BaseService;

public interface ExerciseService extends BaseService<Exercise, Integer> {

    List<Exercise> findAllByWorkoutId(int id);

}
