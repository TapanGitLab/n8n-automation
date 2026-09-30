package com.example.demo.web;

import com.example.demo.repo.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final EmployeeRepository repo;

    public LoginController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employees", repo.findAll());
        return "home";
    }
}
