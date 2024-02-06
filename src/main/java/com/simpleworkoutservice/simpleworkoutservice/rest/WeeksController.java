package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.Week;
import com.simpleworkoutservice.simpleworkoutservice.service.WeekService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeeksController {

    private WeekService weekService;

    @Autowired
    public WeeksController(WeekService weekService) {
        this.weekService = weekService;

    }

    @GetMapping("/weeks/plan/{planId}")
    public List<Week> getWeeksByPlanId(@PathVariable("planId") int planId) {

        List<Week> weeks = weekService.findAllByPlanId(planId);

        if (weeks == null) {
            throw new RuntimeException("Weeks not found with plan id - " + planId);
        }

        return weeks;
    }

}
