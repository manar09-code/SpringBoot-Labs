package com.example.studentportal.service;

import com.example.studentportal.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> studentDb = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public StudentServiceImpl() {
        Student s1 = new Student(idCounter.incrementAndGet(), "John Doe", 21, "john@example.com", "Computer Science", "CS123456");
        Student s2 = new Student(idCounter.incrementAndGet(), "Jane Smith", 22, "jane@example.com", "Mathematics", "MT789012");
        Student s3 = new Student(idCounter.incrementAndGet(), "Bob Johnson", 20, "bob@example.com", "Physics", "PH345678");
        studentDb.put(s1.getId(), s1);
        studentDb.put(s2.getId(), s2);
        studentDb.put(s3.getId(), s3);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDb.values());
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(studentDb.get(id));
    }

    @Override
    public Student saveStudent(Student student) {
        if (student.getId() == null) {
            student.setId(idCounter.incrementAndGet());
        }
        studentDb.put(student.getId(), student);
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        studentDb.remove(id);
    }
}
