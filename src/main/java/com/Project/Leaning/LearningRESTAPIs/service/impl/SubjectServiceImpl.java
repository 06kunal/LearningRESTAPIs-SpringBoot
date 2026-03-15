package com.Project.Leaning.LearningRESTAPIs.service.impl;

import com.Project.Leaning.LearningRESTAPIs.dto.SubjectDto;
import com.Project.Leaning.LearningRESTAPIs.dto.TaskDto;
import com.Project.Leaning.LearningRESTAPIs.entity.ClassEntity;
import com.Project.Leaning.LearningRESTAPIs.entity.Student;
import com.Project.Leaning.LearningRESTAPIs.entity.Subject;
import com.Project.Leaning.LearningRESTAPIs.repository.ClassRepository;
import com.Project.Leaning.LearningRESTAPIs.repository.StudentRepository;
import com.Project.Leaning.LearningRESTAPIs.repository.SubjectRepository;
import com.Project.Leaning.LearningRESTAPIs.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;
    private final ClassRepository classRepository;

    @Override
    public SubjectDto createSubject(Long classId, SubjectDto subjectDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String adminName = authentication.getName();

        ClassEntity classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Subject newSubject = modelMapper.map(subjectDto, Subject.class);
        newSubject.setCreatedBy(adminName);
        newSubject.setClassEntity(classEntity);


        if (newSubject.getActive() == null) {
            newSubject.setActive(true);
        }

        Subject subject = subjectRepository.save(newSubject);

        SubjectDto response = modelMapper.map(subject, SubjectDto.class);

        response.setClassId(classEntity.getId());
        response.setClassName(classEntity.getClassName());

        return response;
    }

    @Override
    public SubjectDto getSubjectById(Long classId, Long id) {

        Subject subject = subjectRepository
                .findByIdAndClassEntityId(id, classId)
                .orElseThrow(() -> new RuntimeException("Subject not found in this class"));

        SubjectDto subjectDto = modelMapper.map(subject, SubjectDto.class);

        List<TaskDto> tasks = subject.getTasks()
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .toList();

        subjectDto.setTasks(tasks);

        // add class information
        subjectDto.setClassId(subject.getClassEntity().getId());
        subjectDto.setClassName(subject.getClassEntity().getClassName());

        return subjectDto;
    }

    @Override
    public List<SubjectDto> getAllSubjects(Long classId) {
        classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        List<Subject> subjects = subjectRepository.findByClassEntityId(classId);

        return subjects.stream().map(subject -> {
            SubjectDto dto = modelMapper.map(subject, SubjectDto.class);
            dto.setClassId(subject.getClassEntity().getId());
            dto.setClassName(subject.getClassEntity().getClassName());
            return dto;
        }).toList();
    }

    @Override
    public SubjectDto updateSubject(Long classId, Long id, SubjectDto subjectDto) {

        Subject subject = subjectRepository
                .findByIdAndClassEntityId(id, classId)
                .orElseThrow(() -> new RuntimeException("Subject not found in this class"));

        subject.setSubjectName(subjectDto.getSubjectName());
        subject.setSubjectDescription(subjectDto.getSubjectDescription());

        return getSubjectDto(classId, subject);
    }

    @Override
    public SubjectDto patchSubject(Long classId, Long id, SubjectDto subjectDto) {

        Subject subject = subjectRepository
                .findByIdAndClassEntityId(id, classId)
                .orElseThrow(() -> new RuntimeException("Subject not found in this class"));

        if (subjectDto.getSubjectName() != null) {
            subject.setSubjectName(subjectDto.getSubjectName());
        }

        if (subjectDto.getSubjectDescription() != null) {
            subject.setSubjectDescription(subjectDto.getSubjectDescription());
        }

        return getSubjectDto(classId, subject);
    }

    private SubjectDto getSubjectDto(Long classId, Subject subject) {
        Subject updatedSubject = subjectRepository.save(subject);

        SubjectDto response = modelMapper.map(updatedSubject, SubjectDto.class);

        ClassEntity classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        response.setClassId(classEntity.getId());
        response.setClassName(classEntity.getClassName());

        return response;
    }

    @Override
    public void deleteSubject(Long classId, Long id) {

        Subject subject = subjectRepository
                .findByIdAndClassEntityId(id, classId)
                .orElseThrow(() -> new RuntimeException("Subject not found in this class"));


        subjectRepository.delete(subject);
    }
}
