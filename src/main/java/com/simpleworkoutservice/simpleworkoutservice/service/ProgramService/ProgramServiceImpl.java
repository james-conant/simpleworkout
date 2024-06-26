package com.simpleworkoutservice.simpleworkoutservice.service.ProgramService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpleworkoutservice.simpleworkoutservice.dao.ProgramRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Program;

@Service
public class ProgramServiceImpl implements ProgramService {

    private ProgramRepository programRepo;

    @Autowired
    public ProgramServiceImpl(ProgramRepository programRepo) {
        this.programRepo = programRepo;
    }

    @Override
    public List<Program> findAll() {
        return programRepo.findAll();
    }

    @Override
    public Program findById(Long id) {
        Optional<Program> result = programRepo.findById(id);

        Program dbProgram = null;
        if (result.isPresent()) {
            dbProgram = result.get();
        } else {
            throw new RuntimeException("Did not find program id - " + id);
        }

        return dbProgram;

    }

    @Override
    public Program save(Program program) {
        return programRepo.save(program);

    }

    @Override
    public Program update(Long id, Program program) {
        return programRepo.save(program);
    }

    @Override
    public void deleteById(Long id) {
        programRepo.deleteById(id);
    }

}
