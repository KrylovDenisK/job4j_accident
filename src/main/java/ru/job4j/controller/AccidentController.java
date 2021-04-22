package ru.job4j.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.model.Accident;
import ru.job4j.service.Service;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AccidentController {
    private final Service accidents;

    public AccidentController(Service accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String createAccident(Model model) {
        model.addAttribute("types", accidents.getTypes());
        model.addAttribute("rules", accidents.getRules());
        return "accident/save";
    }

    @PostMapping("/save")
    public String saveAccident(@ModelAttribute Accident accident, HttpServletRequest req) {
        Accident acc = accidents.setProperties(accident, req.getParameterValues("rIds"));
        accidents.save(acc);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateAccident(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.getForUpdate(id));
        model.addAttribute("types", accidents.getTypes());
        model.addAttribute("rules", accidents.getRules());
        return "accident/update";
    }
}
