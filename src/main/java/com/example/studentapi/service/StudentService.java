package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDTO;
import com.example.studentapi.exception.DuplicateStudentException;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.mapper.StudentMapper;
import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,
                          StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    // CREATE
    public StudentDTO addStudent(StudentDTO studentDTO) {

        Student student = studentMapper.toEntity(studentDTO);

        if (studentRepository.existsById(student.getId())) {
            throw new DuplicateStudentException("Student already exists");
        }

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toDTO(savedStudent);
    }

    // READ BY ID
    public StudentDTO getStudent(Integer id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        return studentMapper.toDTO(student);
    }

    // DELETE
    public void deleteStudent(Integer id) {

        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }

        studentRepository.deleteById(id);
    }

    // FILTER BY AGE
    public List<StudentDTO> getStudentsAboveAge(int age) {

        List<Student> students = studentRepository.findByAgeGreaterThan(age);

        return students.stream()
                .map(studentMapper::toDTO)
                .toList();
    }

    // FIND BY EMAIL
    public StudentDTO getStudentByEmail(String email) {

        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student with email " + email + " not found."));

        return studentMapper.toDTO(student);
    }

    // PAGINATION
    public Page<StudentDTO> getStudents(Pageable pageable) {

        return studentRepository.findAll(pageable)
                .map(studentMapper::toDTO);
    }

    // UPDATE
    public StudentDTO updateStudent(Integer id, StudentDTO updatedStudentDTO) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student with id " + id + " not found"));

        existingStudent.setName(updatedStudentDTO.getName());
        existingStudent.setEmail(updatedStudentDTO.getEmail());
        existingStudent.setAge(updatedStudentDTO.getAge());

        Student savedStudent = studentRepository.save(existingStudent);

        return studentMapper.toDTO(savedStudent);
    }
}