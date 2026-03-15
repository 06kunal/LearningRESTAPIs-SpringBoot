package com.Project.Leaning.LearningRESTAPIs.repository;

import com.Project.Leaning.LearningRESTAPIs.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findBySubjectId(Long subjectId);
}
