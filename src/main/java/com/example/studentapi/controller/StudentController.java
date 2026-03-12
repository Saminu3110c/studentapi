package com.example.studentapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import com.example.studentapi.dto.StudentDTO;
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

    @Operation(summary = "Create a student")
    @PostMapping
    public ApiResponse<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO) {

        StudentDTO created = studentService.addStudent(studentDTO);

        return new ApiResponse<>(
                true,
                "Student added successfully",
                created
        );
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public ApiResponse<StudentDTO> getStudent(@PathVariable Integer id) {

        StudentDTO student = studentService.getStudent(id);

        return new ApiResponse<>(
                true,
                "Student retrieved successfully",
                student
        );
    }

    @Operation(summary = "Delete a student")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteStudent(@PathVariable Integer id) {

        studentService.deleteStudent(id);

        return new ApiResponse<>(
                true,
                "Student deleted successfully",
                null
        );
    }

    @Operation(summary = "Get all students (5 per page by default)")
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

    @Operation(summary = "Get students above a given age")
    @GetMapping("/above/{age}")
    public ApiResponse<List<StudentDTO>> getStudentsAboveAge(@PathVariable int age) {

        List<StudentDTO> students = studentService.getStudentsAboveAge(age);

        return new ApiResponse<>(
                true,
                "Students retrieved successfully",
                students
        );
    }

    @Operation(summary = "Get student by Email")
    @GetMapping("/email/{email}")
    public ApiResponse<StudentDTO> getStudentByEmail(@PathVariable String email) {

        StudentDTO student = studentService.getStudentByEmail(email);

        return new ApiResponse<>(
                true,
                "Student retrieved successfully",
                student
        );
    }

    @Operation(summary = "Update a student")
    @PutMapping("/{id}")
    public ApiResponse<StudentDTO> updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody StudentDTO studentDTO) {

        StudentDTO updated = studentService.updateStudent(id, studentDTO);

        return new ApiResponse<>(
                true,
                "Student updated successfully",
                updated
        );
    }
}