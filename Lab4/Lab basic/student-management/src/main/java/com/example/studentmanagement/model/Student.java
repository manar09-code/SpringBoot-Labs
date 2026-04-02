package com.example.studentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 100, message = "Age must be less than 100")
    private int age;

    @NotBlank(message = "Major is required")
    private String major;

    public Student() {}

    public Student(String firstName, String lastName, String email, int age, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.major = major;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName +
               "', email='" + email + "', age=" + age + ", major='" + major + "'}";
    }
}
