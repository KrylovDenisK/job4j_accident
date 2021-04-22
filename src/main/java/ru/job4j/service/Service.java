package ru.job4j.service;

import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;

import java.util.List;

public interface Service {
    Accident save(Accident accident);
    List<Accident> getAccidents();
    List<AccidentType> getTypes();
    Accident getForUpdate(int id);
}
