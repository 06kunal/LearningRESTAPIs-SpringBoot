package com.Project.Leaning.LearningRESTAPIs.repository;

import com.Project.Leaning.LearningRESTAPIs.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByClassEntityId(Long classId);

    Optional<Subject> findByIdAndClassEntityId(Long id, Long classId);
}
