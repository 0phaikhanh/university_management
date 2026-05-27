package com.example.university_management.modules.subject.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.subject.dto.SubjectRequestDTO;
import com.example.university_management.modules.subject.entity.Subject;
import com.example.university_management.modules.subject.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor

public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public ApiResponse<PageResponse<Subject>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "majorId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir){
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<Subject> majorPage = subjectService.getAllSubject(pageable);
        return new ApiResponse<>("Major retrieved successfully", PageResponse.of(majorPage));
    }

    @GetMapping("/{id}")
    public ApiResponse<Subject> getById(@PathVariable String id) {
        return new ApiResponse<>("Lecturer retrieved successfully", subjectService.getSubjectById(id));
    }

    @PostMapping
    public ApiResponse<Subject> create(@Valid @RequestBody SubjectRequestDTO dto) {
        return new ApiResponse<>("Lecturer created successfully", subjectService.createSubject(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Subject> update(@PathVariable String id, @Valid @RequestBody SubjectRequestDTO dto) {
        return new ApiResponse<>("Lecturer updated successfully", subjectService.updateSubject(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        subjectService.deleteSubject(id);
        return new ApiResponse<>("Lecturer deleted successfully", null);
    }
}
