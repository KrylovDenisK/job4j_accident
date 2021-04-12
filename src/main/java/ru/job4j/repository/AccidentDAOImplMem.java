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
        store.put(1, new Accident(1, "Name1", "text1", "address1"));
        store.put(2, new Accident(1, "Name2", "text2", "address2"));
        store.put(3, new Accident(1, "Name3", "text3", "address3"));
        this.counter = 3;
    }

    @Override
    public Accident create(Accident accident) {
        counter++;
        accident.setId(counter);
        store.put(counter, accident);
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
