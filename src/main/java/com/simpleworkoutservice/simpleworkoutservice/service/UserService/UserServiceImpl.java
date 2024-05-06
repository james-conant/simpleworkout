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
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findById(Long id) {
		Optional<User> result = userRepo.findById(id);

		User dbUser = null;
		if (result.isPresent()) {
			dbUser = result.get();
		} else {
			throw new RuntimeException("Did not find User id - " + id);
		}

		return dbUser;

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

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User save(User User) {
		return userRepo.save(User);

	}

	@Override
	public User update(Long id, User User) {
		return userRepo.save(User);
	}

	@Override
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}

}
