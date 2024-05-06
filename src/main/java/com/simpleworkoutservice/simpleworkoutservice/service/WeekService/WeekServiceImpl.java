package com.simpleworkoutservice.simpleworkoutservice.service.WeekService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpleworkoutservice.simpleworkoutservice.dao.WeekRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.LiftSet;
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
    public Week findById(Long id) {
        Optional<Week> result = weekRepo.findById(id);

        Week dbWeek = null;
        if (result.isPresent()) {
            dbWeek = result.get();
        } else {
            throw new RuntimeException("Did not find Week id - " + id);
        }

        return dbWeek;

    }

    @Override
    public Week save(Week Week) {
        return weekRepo.save(Week);

    }

    @Override
    public Week update(Long id, Week Week) {
        return weekRepo.save(Week);
    }

    @Override
    public void deleteById(Long id) {
        weekRepo.deleteById(id);
    }

}
