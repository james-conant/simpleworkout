package com.simpleworkoutservice.simpleworkoutservice.service.ProgramService;

import java.util.List;
import com.simpleworkoutservice.simpleworkoutservice.entity.Program;
import com.simpleworkoutservice.simpleworkoutservice.service.BaseService;

public interface ProgramService extends BaseService<Program, Integer> {

    List<Program> findAllByUserId(int programId);

    Program findCurrentProgram(int programId);

}
