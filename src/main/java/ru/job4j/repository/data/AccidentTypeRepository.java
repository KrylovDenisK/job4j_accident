package ru.job4j.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.AccidentType;

public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {
}
