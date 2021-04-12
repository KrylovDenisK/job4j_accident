package ru.job4j.service;

import java.util.List;

public interface Service<T> {
    T create(T entity);
    List<T> getAll();
}
