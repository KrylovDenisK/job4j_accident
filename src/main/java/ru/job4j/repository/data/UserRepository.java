package ru.job4j.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
