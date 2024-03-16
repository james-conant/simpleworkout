package com.simpleworkoutservice.simpleworkoutservice.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleworkoutservice.simpleworkoutservice.dao.UserRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {

		Optional<User> result = userRepo.findById(id);

		User theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}

		return theEmployee;
	}

	@Override
	public User save(User user) {
		if (user.getAuthId() == null) {
			throw new IllegalArgumentException("no authId from action");
		}
		Optional<User> existingUser = userRepo.findByAuthId(user.getAuthId());

		if (existingUser.isPresent()) {
			System.out.println("A user with the same authId already exists");
			return null;
		}

		return userRepo.save(user);
	}

	@Override
	public void deleteById(int userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public User findByAuthId(String authId) {

		Optional<User> result = userRepo.findByAuthId(authId);

		User theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + authId);
		}

		return theEmployee;

	}

}
