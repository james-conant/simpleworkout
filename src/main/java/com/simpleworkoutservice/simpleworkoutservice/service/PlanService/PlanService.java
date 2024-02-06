package com.simpleworkoutservice.simpleworkoutservice.service.PlanService;

import java.util.List;
import com.simpleworkoutservice.simpleworkoutservice.entity.Plan;
import com.simpleworkoutservice.simpleworkoutservice.service.BaseService;

public interface PlanService extends BaseService<Plan, Integer> {

    List<Plan> findAllByUserId(int planId);

}
