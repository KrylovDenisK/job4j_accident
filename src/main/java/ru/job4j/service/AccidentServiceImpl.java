package ru.job4j.service;


import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.model.Rule;
import ru.job4j.repository.data.AccidentRepository;
import ru.job4j.repository.data.AccidentTypeRepository;
import ru.job4j.repository.data.RuleRepository;

import java.util.*;
import java.util.stream.Collectors;


@org.springframework.stereotype.Service
public class AccidentServiceImpl implements Service {
    private final AccidentRepository store;
    private final AccidentTypeRepository types;
    private final RuleRepository rules;


    public AccidentServiceImpl(AccidentRepository store, AccidentTypeRepository types,
                               RuleRepository rules) {
        this.store = store;
        this.types = types;
        this.rules = rules;
    }

    @Override
    public Accident save(Accident entity) {
        return store.save(entity);
    }

    @Override
    public List<AccidentType> getTypes() {
        List<AccidentType> result = new ArrayList<>();
        types.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Accident> getAccidents() {
        return store.findAll();
    }

    @Override
    public Accident getForUpdate(int id) {
        return store.findById(id).orElse(null);
    }

    @Override
    public List<Rule> getRules() {
        List<Rule> result = new ArrayList<>();
        rules.findAll().forEach(result::add);
        return result;
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
                            .map(x -> rules.findById(x).orElse(null))
                            .collect(Collectors.toSet())
            );

        }
        return accident;
    }

    private Accident setAccidentType(Accident accident) {
        int acTypeId = accident.getType().getId();
        accident.setType(types.findById(acTypeId).orElse(null));
        return accident;
    }
}
