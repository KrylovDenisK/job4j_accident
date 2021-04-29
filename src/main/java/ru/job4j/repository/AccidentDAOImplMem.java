package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.repository.StoreDAO;

import java.util.*;

//@Repository
public class AccidentDAOImplMem implements StoreDAO<Accident> {
    private Map<Integer, Accident> store;
    private Integer counter;

    public AccidentDAOImplMem() {
        this.store = new HashMap<>();
        this.counter = 0;
    }

    @Override
    public Accident saveOrUpdate(Accident accident) {
        if (accident.getId() == 0) {
            counter++;
            accident.setId(counter);
            store.put(counter, accident);
        } else {
            store.put(accident.getId(), accident);
        }

        return accident;
    }

    @Override
    public Accident getById(Integer id) {
        return store.get(id);
    }

    @Override
    public void delete(Integer id) {
        store.remove(id);
    }

    @Override
    public List<Accident> getAll() {
        return new ArrayList<>(store.values());
    }
}
