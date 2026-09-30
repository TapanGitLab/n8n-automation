package com.example.demo.web;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/onboarding")
public class OnboardingController {

    private final EmployeeRepository repo;

    public OnboardingController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String form(Model model) {
        model.addAttribute("employee", new Employee());
        return "onboarding";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "onboarding";
        }
        repo.save(employee);
        redirect.addFlashAttribute("message", "User '" + employee.getName() + "' created successfully");
        return "redirect:/";
    }
}
