package ru.job4j.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "accident/save";
    }

    @PostMapping("/save")
    public String saveAccident(@ModelAttribute Accident accident) {
        accidents.save(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateAccident(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.getById(id));
        return "accident/update";
    }
}
