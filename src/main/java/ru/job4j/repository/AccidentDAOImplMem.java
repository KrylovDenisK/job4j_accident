package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.*;

@Repository
public class AccidentDAOImplMem implements StoreDAO<Accident> {
    private Map<Integer, Accident> store;
    private Integer counter;

    public AccidentDAOImplMem() {
        this.store = new HashMap<>();
        Accident first = new Accident("Имя1", "text1", "address1");
        Accident second = new Accident("Имя3", "text2", "address2");
        first.setId(1);
        second.setId(2);
        store.put(1, first);
        store.put(2, second);
        this.counter = 2;
    }

    @Override
    public Accident save(Accident accident) {
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
    public Accident delete(Integer id) {
        return store.remove(id);
    }

    @Override
    public List<Accident> getAll() {
        return new ArrayList<>(store.values());
    }
}
