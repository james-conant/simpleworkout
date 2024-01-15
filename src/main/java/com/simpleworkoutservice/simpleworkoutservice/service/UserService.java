package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;

import com.simpleworkoutservice.simpleworkoutservice.entity.User;

public interface UserService {

	public User findByUserName(String userName);

    public List<User> findAll();

    public User findById(int id);

    public User save(User user);

    public void deleteById(int userId);

}
