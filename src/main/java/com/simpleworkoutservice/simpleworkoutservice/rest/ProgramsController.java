package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.Program;
import com.simpleworkoutservice.simpleworkoutservice.service.ProgramService.ProgramService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProgramsController {

    private ProgramService programService;

    @Autowired
    public ProgramsController(ProgramService programService) {
        this.programService = programService;

    }

    @GetMapping("/programs")
    public List<Program> getPrograms(@RequestHeader("userId") int userId) {

        if (userId == 0) {
            throw new RuntimeException("No user Id given: " + userId);
        }
        List<Program> programs = programService.findAllByUserId(userId);

        if (programs == null) {
            throw new RuntimeException("No programs found with user id: " + userId);
        }

        return programs;
    }

    @GetMapping("/programs/{id}")
    public Program getProgramByUserId(@RequestHeader("programId") int programId) {

        Program program = programService.findById(programId);

        if (program == null) {
            throw new RuntimeException("No programs found with program id: " + programId);
        }

        return program;
    }

    @GetMapping("/programs/current")
    public Program getCurrentProgram(@RequestHeader("userId") int userId) {

        if (userId == 0) {
            throw new RuntimeException("No user Id given: " + userId);
        }

        Program program = programService.findCurrentProgram(userId);

        if (program == null) {
            throw new RuntimeException("No current program found with userId: " + userId);
        }

        return program;
    }

}
