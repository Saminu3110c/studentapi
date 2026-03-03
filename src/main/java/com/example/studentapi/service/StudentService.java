package com.example.studentapi.service;

import com.example.studentapi.exception.DuplicateStudentException;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(Student student) {
        if (repository.existsById(student.getId())) {
            throw new DuplicateStudentException("Student already exists");
        }
        repository.save(student);
    }

    public Student getStudent(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new StudentNotFoundException("Student not found"));
    }

    public void deleteStudent(Integer id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }
        repository.deleteById(id);
    }

    public List<Student> getStudentsAboveAge(int age) {
        return repository.findAll().stream()
                .filter(student -> student.getAge() > age)
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudents() {
        return repository.findAll().stream().toList();
    }
}