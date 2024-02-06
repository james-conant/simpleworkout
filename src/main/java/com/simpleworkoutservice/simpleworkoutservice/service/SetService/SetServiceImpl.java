package com.simpleworkoutservice.simpleworkoutservice.service.SetService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleworkoutservice.simpleworkoutservice.dao.SetRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.Set;
import com.simpleworkoutservice.simpleworkoutservice.service.BaseService;

@Service
public class SetServiceImpl implements BaseService<Set, Integer> {

    private SetRepository setRepo;

    @Autowired
    public SetServiceImpl(SetRepository setRepo) {
        this.setRepo = setRepo;
    }

    @Override
    public List<Set> findAll() {
        return setRepo.findAll();
    }

    @Override
    public Set findById(int id) {

        Optional<Set> result = setRepo.findById(id);

        Set dbWorkout = null;

        if (result.isPresent()) {
            dbWorkout = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return dbWorkout;
    }

    @Override
    public Set save(Set user) {
        return setRepo.save(user);
    }

    @Override
    public void deleteById(int userId) {
        setRepo.deleteById(userId);
    }

}
