package com.simpleworkoutservice.simpleworkoutservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    List<Plan> findAllByUserId(int planId);

}
