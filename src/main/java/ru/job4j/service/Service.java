package ru.job4j.service;

import java.util.List;

public interface Service<T> {
    T save(T entity);
    List<T> getAll();
    T getById(int id);
}
