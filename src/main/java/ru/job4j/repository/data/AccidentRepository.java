package ru.job4j.repository.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.model.Accident;

import java.util.List;
import java.util.Optional;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    @Query("SELECT DISTINCT accident FROM ru.job4j.model.Accident accident " +
            "LEFT JOIN FETCH accident.type at LEFT JOIN FETCH accident.rules")
    List<Accident> findAll();
    @Query("SELECT DISTINCT accident FROM ru.job4j.model.Accident accident " +
            "JOIN FETCH accident.type LEFT JOIN FETCH accident.rules WHERE accident.id = :id ")
    Optional<Accident> findById(@Param("id") Integer id);

}
