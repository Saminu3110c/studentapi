package com.example.studentapi.service;

import com.example.studentapi.exception.DuplicateStudentException;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
// import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository repository) {
        this.studentRepository = repository;
    }

    public void addStudent(Student student) {
        if (studentRepository.existsById(student.getId())) {
            throw new DuplicateStudentException("Student already exists");
        }
        studentRepository.save(student);
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                    new StudentNotFoundException("Student not found"));
    }

    public void deleteStudent(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    // public List<Student> getStudentsAboveAge(int age) {
    //     return studentRepository.findAll().stream()
    //             .filter(student -> student.getAge() > age)
    //             .collect(Collectors.toList());
    // }

    public List<Student> getStudentsAboveAge(int age){
        return studentRepository.findByAgeGreaterThan(age);
    }

    public Student getStudentByEmail(String email){
        return studentRepository.findByEmail(email)
        .orElseThrow(()->new StudentNotFoundException("Student with email " + email + " not found."));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().toList();
    }

    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student updateStudent(Integer id, Student updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with id " + id + " not found"));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAge(updatedStudent.getAge());

        return studentRepository.save(existingStudent);
    }
}