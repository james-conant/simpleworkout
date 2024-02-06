package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;
import com.simpleworkoutservice.simpleworkoutservice.entity.Week;

public interface WeekService extends BaseService<Week, Integer> {

    public List<Week> findAllByUserId(int id);

    public List<Week> findAllByPlanId(int planId);

}
