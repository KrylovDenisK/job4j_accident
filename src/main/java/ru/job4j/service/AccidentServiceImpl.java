package ru.job4j.service;

import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.StoreDAO;

import java.util.List;

@org.springframework.stereotype.Service
public class AccidentServiceImpl implements Service {
    private final StoreDAO<Accident> store;
    private final StoreDAO<AccidentType> types;


    public AccidentServiceImpl(StoreDAO<Accident> store, StoreDAO<AccidentType> types) {
        this.store = store;
        this.types = types;
    }

    @Override
    public Accident save(Accident entity) {
        int acTypeId = entity.getType().getId();
        entity.setType(types.getById(acTypeId));
        return store.save(entity);
    }

    @Override
    public List<AccidentType> getTypes() {
        return types.getAll();
    }

    @Override
    public List<Accident> getAccidents() {
        return store.getAll();
    }

    @Override
    public Accident getForUpdate(int id) {
        return store.getById(id);
    }
}
