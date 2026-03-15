package com.Project.Leaning.LearningRESTAPIs.service.impl;

import com.Project.Leaning.LearningRESTAPIs.dto.RegisterRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.StudentDto;
import com.Project.Leaning.LearningRESTAPIs.entity.Student;
import com.Project.Leaning.LearningRESTAPIs.enums.Role;
import com.Project.Leaning.LearningRESTAPIs.repository.ClassRepository;
import com.Project.Leaning.LearningRESTAPIs.repository.StudentRepository;
import com.Project.Leaning.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final ModelMapper modelMapper;

    private Student getStudentOrThrow(Long classId, Long studentId) {
        return studentRepository
                .findByIdAndClassEntityId(studentId, classId)
                .orElseThrow(() -> new RuntimeException("Student not found in this class"));
    }

    @Override
    public List<StudentDto> getAllStudents(Long classId) {

        classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        List<Student> students = studentRepository.findByClassEntityId(classId);

        return students.stream().map(student -> {
            StudentDto dto = modelMapper.map(student, StudentDto.class);
            dto.setClassId(student.getClassEntity().getId());
            dto.setClassName(student.getClassEntity().getClassName());
            return dto;
        }).toList();
    }


    @Override
    public StudentDto getStudentByID(Long classId, Long studentId) {

        Student student = getStudentOrThrow(classId, studentId);

        StudentDto dto = modelMapper.map(student, StudentDto.class);

        dto.setClassId(student.getClassEntity().getId());
        dto.setClassName(student.getClassEntity().getClassName());

        return dto;
    }

    @Override
    public void deleteStudentById(Long classId, Long studentId) {

        Student student = getStudentOrThrow(classId, studentId);

        studentRepository.delete(student);
    }

    @Override
    public StudentDto updateStudent(Long classId, Long studentId, RegisterRequestDto registerRequestDto) {
        Student student = getStudentOrThrow(classId, studentId);

        student.setName(registerRequestDto.getName());
        student.setEmail(registerRequestDto.getEmail());

        Student updatedStudent = studentRepository.save(student);

        StudentDto dto = modelMapper.map(updatedStudent, StudentDto.class);

        dto.setClassId(updatedStudent.getClassEntity().getId());
        dto.setClassName(updatedStudent.getClassEntity().getClassName());

        return dto;
    }

    @Override
    public StudentDto updatePartialStudent(Long classId, Long studentId, RegisterRequestDto registerRequestDto) {

        Student student = getStudentOrThrow(classId, studentId);

        if (registerRequestDto.getName() != null) {
            student.setName(registerRequestDto.getName());
        }

        if (registerRequestDto.getEmail() != null) {
            student.setEmail(registerRequestDto.getEmail());
        }

        Student updatedStudent = studentRepository.save(student);

        StudentDto dto = modelMapper.map(updatedStudent, StudentDto.class);

        dto.setClassId(updatedStudent.getClassEntity().getId());
        dto.setClassName(updatedStudent.getClassEntity().getClassName());

        return dto;
    }
}
