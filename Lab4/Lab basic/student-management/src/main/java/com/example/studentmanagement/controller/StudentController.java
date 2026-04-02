package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        student.setId(id);
        try {
            Student updatedStudent = studentService.updateStudent(student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {
        return new ResponseEntity<>(studentService.getStudentsByMajor(major), HttpStatus.OK);
    }

    @GetMapping("/younger-than/{age}")
    public ResponseEntity<List<Student>> getStudentsYoungerThan(@PathVariable int age) {
        return new ResponseEntity<>(studentService.getStudentsYoungerThan(age), HttpStatus.OK);
    }

    @GetMapping("/by-lastname/{pattern}")
    public ResponseEntity<List<Student>> getStudentsByLastNamePattern(@PathVariable String pattern) {
        return new ResponseEntity<>(studentService.getStudentsByLastNamePattern(pattern), HttpStatus.OK);
    }

    @GetMapping("/age-range")
    public ResponseEntity<List<Student>> getStudentsInAgeRange(
            @RequestParam int minAge, @RequestParam int maxAge) {
        return new ResponseEntity<>(studentService.getStudentsInAgeRange(minAge, maxAge), HttpStatus.OK);
    }
}
