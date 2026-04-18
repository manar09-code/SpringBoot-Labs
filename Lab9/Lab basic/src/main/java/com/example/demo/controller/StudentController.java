package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

private final StudentRepository repo;

public StudentController(StudentRepository repo){
this.repo=repo;
}

@GetMapping
public List<Student> all(){ return repo.findAll(); }

@PostMapping
public Student create(@RequestBody Student s){ return repo.save(s); }

@GetMapping("/{id}")
public Student one(@PathVariable Long id){
return repo.findById(id).orElseThrow();
}
}
