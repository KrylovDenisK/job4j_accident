package ru.job4j.service;

import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.model.Rule;
import ru.job4j.repository.StoreDAO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class AccidentServiceImpl implements Service {
    private final StoreDAO<Accident> store;
    private final StoreDAO<AccidentType> types;
    private final StoreDAO<Rule> rules;


    public AccidentServiceImpl(StoreDAO<Accident> store, StoreDAO<AccidentType> types
            , StoreDAO<Rule> rules) {
        this.store = store;
        this.types = types;
        this.rules = rules;
    }

    @Override
    public Accident save(Accident entity) {
        return store.saveOrUpdate(entity);
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

    @Override
    public List<Rule> getRules() {
        return rules.getAll();
    }

    @Override
    public Accident setProperties(Accident accident, String[] ids) {
        Accident withRules = setRules(accident, ids);
        return setAccidentType(withRules);
    }

    private Accident setRules(Accident accident, String[] ids) {
        if (ids != null) {
            accident.setRules(
                    Arrays.stream(ids)
                            .map(Integer::parseInt)
                            .map(x -> rules.getById(x))
                            .collect(Collectors.toSet())
            );
        }
        return accident;
    }

    private Accident setAccidentType(Accident accident) {
        int acTypeId = accident.getType().getId();
        accident.setType(types.getById(acTypeId));
        return accident;
    }
}
