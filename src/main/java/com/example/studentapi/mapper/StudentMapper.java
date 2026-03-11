package com.example.studentapi.mapper;

import com.example.studentapi.dto.StudentDTO;
import com.example.studentapi.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO studentDTO);

}