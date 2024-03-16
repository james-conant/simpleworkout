package com.simpleworkoutservice.simpleworkoutservice.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Week;

public interface WeekRepository extends JpaRepository<Week, Integer> {

    List<Week> findAllByUserId(int id);

    List<Week> findAllByProgramId(int programId);

}
