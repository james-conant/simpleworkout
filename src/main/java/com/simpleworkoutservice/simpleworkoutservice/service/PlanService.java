package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;
import com.simpleworkoutservice.simpleworkoutservice.entity.Plan;

public interface PlanService extends BaseService<Plan, Integer> {

    List<Plan> findAllByUserId(int planId);

}
