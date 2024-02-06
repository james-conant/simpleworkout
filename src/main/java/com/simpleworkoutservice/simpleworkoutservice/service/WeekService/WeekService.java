package com.simpleworkoutservice.simpleworkoutservice.service.WeekService;

import java.util.List;
import com.simpleworkoutservice.simpleworkoutservice.entity.Week;
import com.simpleworkoutservice.simpleworkoutservice.service.BaseService;

public interface WeekService extends BaseService<Week, Integer> {

    public List<Week> findAllByUserId(int id);

    public List<Week> findAllByPlanId(int planId);

}
