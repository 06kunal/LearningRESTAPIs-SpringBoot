package com.Project.Leaning.LearningRESTAPIs.controller;

import com.Project.Leaning.LearningRESTAPIs.dto.RegisterRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.StudentDto;
import com.Project.Leaning.LearningRESTAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classes/{classId}/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(@PathVariable Long classId) {
        return ResponseEntity.ok(studentService.getAllStudents(classId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long classId, @PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentByID(classId, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long classId, @PathVariable Long id){
        studentService.deleteStudentById(classId, id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long classId, @PathVariable Long id, @RequestBody @Valid RegisterRequestDto registerRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(classId, id, registerRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long classId, @PathVariable Long id, @RequestBody @Valid RegisterRequestDto registerRequestDto){
        return ResponseEntity.ok(studentService.updatePartialStudent(classId, id, registerRequestDto));
    }
}
