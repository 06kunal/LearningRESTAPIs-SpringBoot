package com.Project.Leaning.LearningRESTAPIs.repository;

import com.Project.Leaning.LearningRESTAPIs.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}