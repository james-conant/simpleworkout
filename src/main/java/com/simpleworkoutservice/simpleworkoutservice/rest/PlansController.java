package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.Plan;
import com.simpleworkoutservice.simpleworkoutservice.service.PlanService.PlanService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlansController {

    private PlanService planService;

    @Autowired
    public PlansController(PlanService planService) {
        this.planService = planService;

    }

    @GetMapping("/plans")
    public List<Plan> getPlans(@RequestHeader("userId") int userId) {

        List<Plan> plans = planService.findAllByUserId(userId);

        if (plans == null) {
            throw new RuntimeException("No plans found with user id: " + userId);
        }

        return plans;
    }

    @GetMapping("/plans/{id}")
    public Plan getPlanByUserId(@RequestHeader("userId") int planId) {

        Plan plan = planService.findById(planId);

        if (plan == null) {
            throw new RuntimeException("No plans found with plan id: " + planId);
        }

        return plan;
    }

}
