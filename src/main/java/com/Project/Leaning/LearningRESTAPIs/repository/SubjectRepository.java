package com.Project.Leaning.LearningRESTAPIs.repository;

import com.Project.Leaning.LearningRESTAPIs.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
