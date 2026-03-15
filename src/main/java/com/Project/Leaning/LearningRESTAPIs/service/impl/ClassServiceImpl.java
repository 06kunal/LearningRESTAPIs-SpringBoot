package com.Project.Leaning.LearningRESTAPIs.service.impl;

import com.Project.Leaning.LearningRESTAPIs.entity.ClassEntity;
import com.Project.Leaning.LearningRESTAPIs.repository.ClassRepository;
import com.Project.Leaning.LearningRESTAPIs.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;


    public ClassEntity createClass(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }

    public ClassEntity getClassById(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
