package com.Project.Leaning.LearningRESTAPIs.service;

import com.Project.Leaning.LearningRESTAPIs.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(Long subjectId, TaskDto taskDto);

    List<TaskDto> getTasksBySubject(Long subjectId);

    TaskDto getTask(Long subjectId, Long taskId);

    TaskDto updateTask(Long subjectId, Long taskId, TaskDto taskDto);

    TaskDto patchTask(Long subjectId, Long taskId, TaskDto taskDto);

    void deleteTask(Long subjectId, Long taskId);
}
