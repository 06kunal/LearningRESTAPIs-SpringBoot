package com.Project.Leaning.LearningRESTAPIs.controller;

import com.Project.Leaning.LearningRESTAPIs.dto.StudentDto;
import com.Project.Leaning.LearningRESTAPIs.dto.SubjectDto;
import com.Project.Leaning.LearningRESTAPIs.entity.Subject;
import com.Project.Leaning.LearningRESTAPIs.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classes/{classId}/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/create")
    public ResponseEntity<SubjectDto> createSubject(@PathVariable Long classId, @RequestBody SubjectDto subjectDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.createSubject(classId, subjectDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getSubject(@PathVariable Long classId, @PathVariable Long id) {
        return ResponseEntity.ok(subjectService.getSubjectById(classId, id));
    }

    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAllSubjects(@PathVariable Long classId) {
        return ResponseEntity.ok(subjectService.getAllSubjects(classId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> updateSubject(@PathVariable Long classId, @PathVariable Long id, @RequestBody SubjectDto subjectDto) {
        return ResponseEntity.ok(subjectService.updateSubject(classId, id, subjectDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SubjectDto> patchSubject(@PathVariable Long classId, @PathVariable Long id, @RequestBody SubjectDto subjectDto) {
        return ResponseEntity.ok(subjectService.patchSubject(classId, id, subjectDto));
    }

    @DeleteMapping("{id}")
    public void deleteSubject(@PathVariable Long classId, @PathVariable Long id) {
        subjectService.deleteSubject(classId, id);
    }
}