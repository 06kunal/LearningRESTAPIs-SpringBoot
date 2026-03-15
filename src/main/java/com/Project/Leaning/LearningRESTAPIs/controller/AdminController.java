package com.Project.Leaning.LearningRESTAPIs.controller;


import com.Project.Leaning.LearningRESTAPIs.dto.AdminRequestDto;
import com.Project.Leaning.LearningRESTAPIs.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/promote")
    public String promoteToAdmin(@RequestBody @Valid AdminRequestDto request){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return adminService.promoteToAdmin((request.getEmail()));
    }
}
