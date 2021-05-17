package ru.job4j.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.User;
import ru.job4j.repository.data.RoleRepository;
import ru.job4j.repository.data.UserRepository;

@Service
public class AuthoritiesService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final RoleRepository roles;

    public AuthoritiesService(UserRepository userRepository, PasswordEncoder encoder, RoleRepository roles) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roles = roles;
    }

    public boolean userVerification(String username) {
        return userRepository.findByUsername(username) == null;
    }

    @Transactional
    public void createUser(User user) {
        user.setEnable(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.addRole(roles.findByName("ROLE_USER"));
        userRepository.save(user);
    }

}
