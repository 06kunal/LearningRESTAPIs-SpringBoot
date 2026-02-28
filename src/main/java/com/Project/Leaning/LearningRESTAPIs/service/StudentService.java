package com.Project.Leaning.LearningRESTAPIs.service;

import com.Project.Leaning.LearningRESTAPIs.dto.RegisterRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;


public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentByID(Long id);

    //StudentDto createNewStudent(RegisterRequestDto registerRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, RegisterRequestDto registerRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> update);
}
