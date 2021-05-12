package ru.job4j.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
