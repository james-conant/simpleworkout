package com.simpleworkoutservice.simpleworkoutservice.rest.Programs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.config.security.authentication.SecurityContext;
import com.simpleworkoutservice.simpleworkoutservice.entity.Program;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;
import com.simpleworkoutservice.simpleworkoutservice.service.ProgramService.ProgramService;

import java.util.List;

@RestController
@RequestMapping("/api/program")
public class ProgramsController {

    private ProgramService programService;

    // Add check if userId matches. Eventually we need roles
    @PostMapping
    public Program createProgram(@RequestBody Program newProgram) {
        return programService.save(newProgram);
    }

    @GetMapping
    public List<Program> getAllPrograms() {
        return programService.findAll();
    }

    @GetMapping("/{id}")
    public Program getProgram(@PathVariable Long id) {
        return programService.findById(id);
    }

    @PutMapping("/{id}")
    public Program updateProgram(@PathVariable Long id, @RequestBody Program updatedProgram) {
        return programService.update(id, updatedProgram);
    }

    @DeleteMapping("/{id}")
    public void deleteProgram(@PathVariable Long id) {
        programService.deleteById(id);
    }

}
