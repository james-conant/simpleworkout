package com.simpleworkoutservice.simpleworkoutservice.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.simpleworkoutservice.simpleworkoutservice.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;

	public UserDaoImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public User findByUserName(String username) {

		TypedQuery<User> theQuery = entityManager.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", username);

		User user = null;
		try {
			user = theQuery.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}

	@Override
	public User findById(int id) {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
		return query.setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional
	public User save(User user) {
		User dbUser = entityManager.merge(user);
		user.setId(dbUser.getId());
		return user;
	}

	@Override
	@Transactional
	public void deleteById(int userId) {
		User dbUser = entityManager.find(User.class, userId);
		entityManager.remove(dbUser);
	}

}
