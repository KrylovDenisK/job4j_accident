package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.model.User;
import ru.job4j.service.AuthoritiesService;


@Controller
public class RegController {
    private final AuthoritiesService authoritiesService;

    public RegController(AuthoritiesService userService) {
        this.authoritiesService = userService;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        authoritiesService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "auth/reg";
    }
}