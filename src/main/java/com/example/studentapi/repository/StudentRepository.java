package com.example.studentapi.repository;

import com.example.studentapi.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    private final Map<Integer, Student> students = new HashMap<>();

    public void save(Student student) {
        students.put(student.getId(), student);
    }

    public Optional<Student> findById(Integer id) {
        return Optional.ofNullable(students.get(id));
    }

    public boolean existsById(Integer id) {
        return students.containsKey(id);
    }

    public void deleteById(Integer id) {
        students.remove(id);
    }

    public Collection<Student> findAll() {
        return students.values();
    }
}