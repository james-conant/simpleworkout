package com.simpleworkoutservice.simpleworkoutservice.service;

import com.simpleworkoutservice.simpleworkoutservice.entity.User;

public interface UserService extends BaseService<User, Integer> {

    public User findByUserName(String userName);

}
