package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;


@Controller
public class HelloController {
    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("users", Arrays.asList("somethingOne1","something2","something3"));
        return "hello";
    }
}
