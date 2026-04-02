package com.example.springthymeleaflab.controllers;

import com.example.springthymeleaflab.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/register";
    }

    @PostMapping("/register")
    public String registerStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "students/register";
        }
        students.add(student);
        return "redirect:/students/list";
    }
}
