package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;

public interface BaseService<T, ID> {

    public List<T> findAll();

    public T findById(int id);

    public T save(T user);

    public void deleteById(int userId);

}
