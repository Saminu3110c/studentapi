package com.example.studentapi.controller;

import com.example.studentapi.dto.StudentDTO;
import com.example.studentapi.model.Student;
import com.example.studentapi.response.ApiResponse;
import com.example.studentapi.service.StudentService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService service) {
        this.studentService = service;
    }

    // @PostMapping
    // public void addStudent(@Valid @RequestBody Student student) {
    //     studentService.addStudent(student);
    // }
    @PostMapping
    public ApiResponse<Void> addStudent(@Valid @RequestBody Student student) {

        studentService.addStudent(student);

        return new ApiResponse<>(
                true,
                "Student added successfully",
                null
        );
    }

    // @GetMapping("/{id}")
    // public Student getStudent(@PathVariable Integer id) {
    //     return studentService.getStudent(id);
    // }
    @GetMapping("/{id}")
    public ApiResponse<Student> getStudent(@PathVariable Integer id) {

        Student student = studentService.getStudent(id);

        return new ApiResponse<>(
                true,
                "Student retrieved successfully",
                student
        );
    }


    // @DeleteMapping("/{id}")
    // public void deleteStudent(@PathVariable Integer id) {
    //     studentService.deleteStudent(id);
    // } 
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteStudent(@PathVariable Integer id) {

        studentService.deleteStudent(id);

        return new ApiResponse<>(
                true,
                "Student deleted successfully",
                null
        );
    }

    
    // @GetMapping
    // public Page<StudentDTO> getStudents(@PageableDefault(size = 5) Pageable pageable) {
    //     return studentService.getStudents(pageable);
    // }
    @GetMapping
    public ApiResponse<Page<StudentDTO>> getStudents(
            @PageableDefault(size = 5) Pageable pageable) {

        Page<StudentDTO> students = studentService.getStudents(pageable);

        return new ApiResponse<>(
                true,
                "Students retrieved successfully",
                students
        );
    }

    // @GetMapping("/above/{age}")
    // public List<Student> getStudentsAboveAge(@PathVariable int age) {
    //     return studentService.getStudentsAboveAge(age);
    // }
    @GetMapping("/above/{age}")
    public ApiResponse<List<Student>> getStudentsAboveAge(@PathVariable int age) {

        List<Student> students = studentService.getStudentsAboveAge(age);

        return new ApiResponse<>(
                true,
                "Students retrieved successfully",
                students
        );
    }

    // @GetMapping("/email/{email}")
    // public Student getStudentByEmail(@PathVariable String email) {
    //     return studentService.getStudentByEmail(email);
    // }
    @GetMapping("/email/{email}")
    public ApiResponse<Student> getStudentByEmail(@PathVariable String email) {

        Student student = studentService.getStudentByEmail(email);

        return new ApiResponse<>(
                true,
                "Student retrieved successfully",
                student
        );
    }

    // @PutMapping("/{id}")
    // public Student updateStudent(
    //         @PathVariable Integer id,
    //         @Valid @RequestBody Student student) {

    //     return studentService.updateStudent(id, student);
    // }
    @PutMapping("/{id}")
    public ApiResponse<Student> updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody Student student) {

        Student updated = studentService.updateStudent(id, student);

        return new ApiResponse<>(
                true,
                "Student updated successfully",
                updated
        );
    }
}