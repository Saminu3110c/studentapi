package com.example.studentapi.controller;

import com.example.studentapi.model.Student;
import com.example.studentapi.service.StudentService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService service) {
        this.studentService = service;
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    // @GetMapping
    // public List<Student> getAllStudents() {
    //     return studentService.getAllStudents();
    // }

    @GetMapping
    public Page<Student> getStudents(Pageable pageable) {
        return studentService.getStudents(pageable);
    }

    @GetMapping("/above/{age}")
    public List<Student> getStudentsAboveAge(@PathVariable int age) {
        return studentService.getStudentsAboveAge(age);
    }


    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }
}