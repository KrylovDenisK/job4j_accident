package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        String returnAddress = null;
        if (authoritiesService.userVerification(user.getUsername())) {
            authoritiesService.createUser(user);
            returnAddress = "redirect:/login";
        } else {
            returnAddress = "redirect:/reg?userExist=true";
        }

        return returnAddress;
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(value = "userExist", required = false) String exist,
                      Model model) {
        String errorMessage = null;
        if (exist != null) {
            errorMessage = "Existing username. This username exists. Please enter a different username!!!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "auth/reg";
    }
}