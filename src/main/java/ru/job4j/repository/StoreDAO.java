package ru.job4j.repository;


import java.util.List;

public interface StoreDAO<T> {
    T create(T entity);
    T getById(Integer id);
    T delete(Integer id);
    List<T> getAll();

}
