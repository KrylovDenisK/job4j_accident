package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.model.Accident;
import ru.job4j.service.Service;

@Controller
public class IndexController {
    private final Service accidents;

    public IndexController(Service accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidents.getAccidents());
        return "index";
    }
}
