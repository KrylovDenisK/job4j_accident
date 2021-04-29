package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.StoreDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class AccidentTypeDAOImplMem implements StoreDAO<AccidentType> {
    private Map<Integer, AccidentType> types;

    public AccidentTypeDAOImplMem() {
        types = new HashMap<>();
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    @Override
    public AccidentType saveOrUpdate(AccidentType entity) {
        return null;
    }

    @Override
    public AccidentType getById(Integer id) {
        return types.get(id);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<AccidentType> getAll() {
        return new ArrayList<>(types.values());
    }
}
