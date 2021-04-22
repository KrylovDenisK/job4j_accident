package ru.job4j.service;

import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.model.Rule;

import java.util.List;

public interface Service {
    Accident save(Accident accident);
    List<Accident> getAccidents();
    List<AccidentType> getTypes();
    List<Rule> getRules();
    Accident getForUpdate(int id);
    Accident setProperties(Accident accident, String[] ids);
}
