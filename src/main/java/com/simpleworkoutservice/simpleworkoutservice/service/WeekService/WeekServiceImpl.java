package com.simpleworkoutservice.simpleworkoutservice.service.WeekService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpleworkoutservice.simpleworkoutservice.dao.WeekRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Week;

// This probably doesnt work and not needed

@Service
public class WeekServiceImpl implements WeekService {

    private WeekRepository weekRepo;

    @Autowired
    public WeekServiceImpl(WeekRepository weekRepo) {
        this.weekRepo = weekRepo;
    }

    @Override
    public List<Week> findAll() {
        return weekRepo.findAll();
    }

    @Override
    public Week findById(int id) {

        Optional<Week> result = weekRepo.findById(id);

        Week dbWorkout = null;

        if (result.isPresent()) {
            dbWorkout = result.get();
        } else {
            // we didn't find the week
            throw new RuntimeException("Did not find week id - " + id);
        }

        return dbWorkout;
    }

    public List<Week> findAllByUserId(int id) {
        return weekRepo.findAll();

    }

    @Override
    public Week save(Week user) {
        return weekRepo.save(user);
    }

    @Override
    public void deleteById(int userId) {
        weekRepo.deleteById(userId);
    }

    @Override
    public List<Week> findAllByProgramId(int programId) {
        return weekRepo.findAllByProgramId(programId);
    }

}
