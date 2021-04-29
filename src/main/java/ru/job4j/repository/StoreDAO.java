package ru.job4j.repository;


import java.util.List;

public interface StoreDAO<T> {
    T saveOrUpdate(T entity);
    T getById(Integer id);
    void delete(Integer id);
    List<T> getAll();

}
