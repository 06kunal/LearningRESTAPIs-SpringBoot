package com.Project.Leaning.LearningRESTAPIs.service;

import com.Project.Leaning.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;


public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentByID(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> update);
}
