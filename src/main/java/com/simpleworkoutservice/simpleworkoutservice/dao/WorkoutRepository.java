package com.simpleworkoutservice.simpleworkoutservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
