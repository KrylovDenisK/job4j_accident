package ru.job4j.service;

import ru.job4j.model.Accident;
import ru.job4j.repository.StoreDAO;

import java.util.List;

@org.springframework.stereotype.Service
public class AccidentServiceImpl implements Service<Accident> {
    private final StoreDAO<Accident> store;

    public AccidentServiceImpl(StoreDAO<Accident> store) {
        this.store = store;
    }

    @Override
    public Accident create(Accident entity) {
        return store.create(entity);
    }

    @Override
    public List<Accident> getAll() {
        return store.getAll();
    }
}
