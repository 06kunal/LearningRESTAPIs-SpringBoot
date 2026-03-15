package com.Project.Leaning.LearningRESTAPIs.controller;

import com.Project.Leaning.LearningRESTAPIs.dto.TaskDto;
import com.Project.Leaning.LearningRESTAPIs.service.TaskService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects/{subjectId}/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(
            @PathVariable Long subjectId,
            @RequestBody TaskDto taskDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(subjectId, taskDto));
    }


    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasksBySubject(@PathVariable Long subjectId) {
        return ResponseEntity.ok(taskService.getTasksBySubject(subjectId));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTask(
            @PathVariable Long subjectId,
            @PathVariable Long taskId) {

        return ResponseEntity.ok(taskService.getTask(subjectId, taskId));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable Long subjectId,
            @PathVariable Long taskId,
            @RequestBody TaskDto taskDto) {

        return ResponseEntity.ok(taskService.updateTask(subjectId, taskId, taskDto));
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<TaskDto> patchTask(
            @PathVariable Long subjectId,
            @PathVariable Long taskId,
            @RequestBody TaskDto taskDto) {

        return ResponseEntity.ok(taskService.patchTask(subjectId, taskId, taskDto));
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(
            @PathVariable Long subjectId,
            @PathVariable Long taskId) {

        taskService.deleteTask(subjectId, taskId);
        return "Task deleted successfully";
    }


}
