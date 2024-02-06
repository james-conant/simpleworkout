package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;

import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;

public interface ExerciseService extends BaseService<Exercise, Integer> {

    List<Exercise> findAllByWorkoutId(int id);

}
