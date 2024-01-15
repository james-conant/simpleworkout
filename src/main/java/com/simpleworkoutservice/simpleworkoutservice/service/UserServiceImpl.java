package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleworkoutservice.simpleworkoutservice.dao.UserDao;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;

@Service
public class UserServiceImpl implements UserService {

	

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteById(int userId) {
		userDao.deleteById(userId);
	}

}
