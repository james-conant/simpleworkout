package com.simpleworkoutservice.simpleworkoutservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleworkoutservice.simpleworkoutservice.entity.LiftSet;

public interface LiftSetRepository extends JpaRepository<LiftSet, Integer> {

}
