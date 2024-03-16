package com.simpleworkoutservice.simpleworkoutservice.service.UserService;

import com.simpleworkoutservice.simpleworkoutservice.entity.User;
import com.simpleworkoutservice.simpleworkoutservice.service.BaseService;

public interface UserService extends BaseService<User, Integer> {

    public User findByUsername(String username);

    public User findByAuthId(String authId);

}
