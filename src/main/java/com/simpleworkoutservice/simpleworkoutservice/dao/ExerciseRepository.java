package com.simpleworkoutservice.simpleworkoutservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleworkoutservice.simpleworkoutservice.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}
