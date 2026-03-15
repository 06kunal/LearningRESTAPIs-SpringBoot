package com.Project.Leaning.LearningRESTAPIs.service;

import com.Project.Leaning.LearningRESTAPIs.entity.ClassEntity;

import java.util.List;

public interface ClassService {
    ClassEntity createClass(ClassEntity classEntity);

    List<ClassEntity> getAllClasses();

    ClassEntity getClassById(Long id);

    void deleteClass(Long id);
}
