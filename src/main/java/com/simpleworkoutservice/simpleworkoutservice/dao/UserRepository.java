package com.simpleworkoutservice.simpleworkoutservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleworkoutservice.simpleworkoutservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
    

}
