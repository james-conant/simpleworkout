package com.simpleworkoutservice.simpleworkoutservice.service.SetService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleworkoutservice.simpleworkoutservice.dao.LiftSetRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.LiftSet;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;
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
    public LiftSet findById(int id) {

        Optional<LiftSet> result = liftSetRepo.findById(id);

        LiftSet dbWorkout = null;

        if (result.isPresent()) {
            dbWorkout = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return dbWorkout;
    }

    @Override
    public LiftSet save(LiftSet user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(int userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
