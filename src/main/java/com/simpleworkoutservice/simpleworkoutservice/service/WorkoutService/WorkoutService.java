package com.simpleworkoutservice.simpleworkoutservice.service.WorkoutService;

import java.util.List;
import com.simpleworkoutservice.simpleworkoutservice.entity.Workout;
import com.simpleworkoutservice.simpleworkoutservice.service.BaseService;

public interface WorkoutService extends BaseService<Workout, Integer> {

    public List<Workout> findAllByWeekId(int weekId);

}
