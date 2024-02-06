package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpleworkoutservice.simpleworkoutservice.dao.PlanRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Plan;
import com.simpleworkoutservice.simpleworkoutservice.entity.Week;

@Service
public class PlanServiceImpl implements PlanService {

    private PlanRepository planRepo;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepo) {
        this.planRepo = planRepo;
    }

    @Override
    public List<Plan> findAll() {
        return planRepo.findAll();
    }

    @Override
    public Plan findById(int id) {

        Optional<Plan> result = planRepo.findById(id);

        Plan dbPlan = null;

        if (result.isPresent()) {
            dbPlan = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find plan id - " + id);
        }

        return dbPlan;
    }

    @Override
    public Plan save(Plan plan) {
        return planRepo.save(plan);
    }

    @Override
    public void deleteById(int planId) {
        planRepo.deleteById(planId);
    }

    @Override
    public List<Plan> findAllByUserId(int userId) {
        return planRepo.findAllByUserId(userId);
    }

}
