package com.simpleworkoutservice.simpleworkoutservice.service.SetService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleworkoutservice.simpleworkoutservice.dao.LiftSetRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.LiftSet;
import com.simpleworkoutservice.simpleworkoutservice.service.BaseService;

@Service
public class LiftSetServiceImpl implements BaseService<LiftSet, Integer> {

    private LiftSetRepository liftSetRepo;

    @Autowired
    public LiftSetServiceImpl(LiftSetRepository liftSetRepo) {
        this.liftSetRepo = liftSetRepo;
    }

    @Override
    public List<LiftSet> findAll() {
        return liftSetRepo.findAll();
    }

    @Override
    public LiftSet findById(Long id) {
        Optional<LiftSet> result = liftSetRepo.findById(id);

        LiftSet dbLiftSet = null;
        if (result.isPresent()) {
            dbLiftSet = result.get();
        } else {
            throw new RuntimeException("Did not find LiftSet id - " + id);
        }

        return dbLiftSet;

    }

    @Override
    public LiftSet save(LiftSet LiftSet) {
        return liftSetRepo.save(LiftSet);

    }

    @Override
    public LiftSet update(Long id, LiftSet LiftSet) {
        return liftSetRepo.save(LiftSet);
    }

    @Override
    public void deleteById(Long id) {
        liftSetRepo.deleteById(id);
    }

}
