package com.simpleworkoutservice.simpleworkoutservice.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

    List<Workout> findAllByWeekId(int weekId);

}
