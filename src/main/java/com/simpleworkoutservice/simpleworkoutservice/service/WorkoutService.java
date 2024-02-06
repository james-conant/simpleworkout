package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;

public interface WorkoutService extends BaseService<Workout, Integer> {

    public List<Workout> findAllByWeekId(int weekId);

}
