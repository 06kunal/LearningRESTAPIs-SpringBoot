package com.Project.Leaning.LearningRESTAPIs.service;

import com.Project.Leaning.LearningRESTAPIs.dto.RegisterRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;


public interface StudentService {

    List<StudentDto> getAllStudents(Long classId);

    StudentDto getStudentByID(Long classId, Long studentId);

    //StudentDto createNewStudent(RegisterRequestDto registerRequestDto);

    void deleteStudentById(Long classId, Long id);

    StudentDto updateStudent(Long classId, Long id, RegisterRequestDto registerRequestDto);

    StudentDto updatePartialStudent(Long classId, Long id, RegisterRequestDto registerRequestDto);
}
