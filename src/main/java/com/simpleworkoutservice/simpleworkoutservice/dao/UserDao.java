package com.simpleworkoutservice.simpleworkoutservice.dao;

import java.util.List;

import com.simpleworkoutservice.simpleworkoutservice.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int userId);
    
}
