package com.simpleworkoutservice.simpleworkoutservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    // List<Exercise> findAllByWorkoutId(int id);

}
