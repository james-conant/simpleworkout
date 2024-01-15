package com.simpleworkoutservice.simpleworkoutservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleworkoutservice.simpleworkoutservice.entity.Set;

public interface SetRepository extends JpaRepository<Set, Integer> {

}
