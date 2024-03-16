package com.simpleworkoutservice.simpleworkoutservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer> {

    List<Program> findAllByUserId(int programId);

    Program findFirstByUserIdAndCurrentTrue(int userId);

}
