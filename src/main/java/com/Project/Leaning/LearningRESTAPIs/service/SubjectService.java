package com.Project.Leaning.LearningRESTAPIs.service;

import com.Project.Leaning.LearningRESTAPIs.dto.SubjectDto;
import com.Project.Leaning.LearningRESTAPIs.entity.Subject;

import java.util.List;

public interface SubjectService {

    SubjectDto createSubject(Long classId, SubjectDto subjectdto);

    SubjectDto getSubjectById(Long classId, Long id);

    List<SubjectDto> getAllSubjects(Long classId);

    SubjectDto updateSubject(Long classId, Long id, SubjectDto subjectDto);

    SubjectDto patchSubject(Long classId, Long id, SubjectDto subjectDto);

    void deleteSubject(Long classId, Long id);
}
