package com.Project.Leaning.LearningRESTAPIs.service.impl;

import com.Project.Leaning.LearningRESTAPIs.dto.TaskDto;
import com.Project.Leaning.LearningRESTAPIs.entity.Subject;
import com.Project.Leaning.LearningRESTAPIs.entity.Task;
import com.Project.Leaning.LearningRESTAPIs.enums.TaskStatus;
import com.Project.Leaning.LearningRESTAPIs.repository.SubjectRepository;
import com.Project.Leaning.LearningRESTAPIs.repository.TaskRepository;
import com.Project.Leaning.LearningRESTAPIs.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

import static com.Project.Leaning.LearningRESTAPIs.enums.Role.STUDENT;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    @Override
    public TaskDto createTask(Long subjectId, TaskDto taskDto) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String userEmail = authentication.getName();

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Task task = modelMapper.map(taskDto, Task.class);

        if (task.getActive() == null) {
            task.setActive(true);
        }

        task.setCreatedBy(userEmail);
        task.setSubject(subject);

        Task savedTask = taskRepository.save(task);

        return modelMapper.map(savedTask, TaskDto.class);
    }

    @Override
    public List<TaskDto> getTasksBySubject(Long subjectId) {
        List<Task> tasks = taskRepository.findBySubjectId(subjectId);

        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .toList();
    }

    @Override
    public TaskDto getTask(Long subjectId, Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if(!task.getSubject().getId().equals(subjectId)) {
            throw new RuntimeException("Task does not belong to subject");
        }

        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public TaskDto updateTask(Long subjectId, Long taskId, TaskDto taskDto) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        validateTaskAccess(task);

        if(!task.getSubject().getId().equals(subjectId)){
            throw new RuntimeException("Task does not belong to this subject");
        }

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setTaskStatus(taskDto.getTaskStatus());
        task.setTaskPriority(taskDto.getTaskPriority());

        // completion date logic
        if(taskDto.getTaskStatus() == TaskStatus.COMPLETED) {
            task.setCompletionDate(LocalDateTime.now());
        } else {
            task.setCompletionDate(null);
        }

        Task updatedTask = taskRepository.save(task);

        return modelMapper.map(updatedTask, TaskDto.class);
    }


    @Override
    public TaskDto patchTask(Long subjectId, Long taskId, TaskDto taskDto) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        validateTaskAccess(task);

        if(!task.getSubject().getId().equals(subjectId)){
            throw new RuntimeException("Task does not belong to this subject");
        }

        if(taskDto.getTitle() != null)
            task.setTitle(taskDto.getTitle());

        if(taskDto.getDescription() != null)
            task.setDescription(taskDto.getDescription());

        if(taskDto.getDueDate() != null)
            task.setDueDate(taskDto.getDueDate());

        if(taskDto.getTaskStatus() != null) {
            task.setTaskStatus(taskDto.getTaskStatus());

            if(task.getTaskStatus() == TaskStatus.COMPLETED) {
                task.setCompletionDate(LocalDateTime.now());
            } else {
                task.setCompletionDate(null);
            }
        }

        if(taskDto.getTaskPriority() != null)
            task.setTaskPriority(taskDto.getTaskPriority());

        Task updatedTask = taskRepository.save(task);

        return modelMapper.map(updatedTask, TaskDto.class);
    }

    @Override
    public void deleteTask(Long subjectId, Long taskId) {



        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));



        validateTaskAccess(task);

        if(!task.getSubject().getId().equals(subjectId)) {
            throw new RuntimeException("Task does not belong to subject");
        }

        taskRepository.delete(task);
    }

    private void validateTaskAccess(Task task){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserEmail = authentication.getName();

        boolean isAdmin = authentication.getAuthorities()
                .stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

        if(!isAdmin && !task.getCreatedBy().equals(currentUserEmail)){
            throw new IllegalArgumentException("You don't have the acees to modify this task");
        }
    }

}
