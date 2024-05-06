package com.simpleworkoutservice.simpleworkoutservice.service;

import java.util.List;

public interface BaseService<T, ID> {

    public List<T> findAll();

    public T findById(Long id);

    public T save(T object);

    public T update(Long id, T object);

    public void deleteById(Long id);

}
