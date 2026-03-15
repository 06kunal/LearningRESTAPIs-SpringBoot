package com.Project.Leaning.LearningRESTAPIs.controller;


import com.Project.Leaning.LearningRESTAPIs.entity.ClassEntity;
import com.Project.Leaning.LearningRESTAPIs.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classes")

public class ClassController {

    private final ClassService classService;

    @PostMapping("/create")
    public ClassEntity createClass(@RequestBody ClassEntity classEntity) {
        return classService.createClass(classEntity);
    }

    @GetMapping
    public List<ClassEntity> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ClassEntity getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }
}
