package ru.job4j.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.model.Accident;
import ru.job4j.service.Service;

@Controller
public class AccidentController {
    private final Service<Accident> accidents;

    public AccidentController(Service<Accident> accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String createAccident() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String saveAccident(@ModelAttribute Accident accident) {
        accidents.create(accident);
        return "redirect:/";
    }
}
