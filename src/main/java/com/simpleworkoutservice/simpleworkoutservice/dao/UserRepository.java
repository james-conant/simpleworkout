package com.simpleworkoutservice.simpleworkoutservice.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAuthId(String authId);

    User findByUsername(String username);

}
