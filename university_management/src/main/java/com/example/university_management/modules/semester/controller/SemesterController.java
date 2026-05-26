package com.example.university_management.modules.semester.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.modules.semester.dto.SemesterRequestDTO;
import com.example.university_management.modules.semester.entity.Semester;
import com.example.university_management.modules.semester.service.SemesterService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semesters")
public class SemesterController {

    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping
    public ApiResponse<List<Semester>> getAll() {
        return new ApiResponse<>("Semesters retrieved successfully", semesterService.getAllSemesters());
    }

    @GetMapping("/{id}")
    public ApiResponse<Semester> getById(@PathVariable String id) {
        return new ApiResponse<>("Semester retrieved successfully", semesterService.getSemesterById(id));
    }

    @PostMapping
    public ApiResponse<Semester> create(@Valid @RequestBody SemesterRequestDTO dto) {
        return new ApiResponse<>("Semester created successfully", semesterService.createSemester(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Semester> update(@PathVariable String id, @Valid @RequestBody SemesterRequestDTO dto) {
        return new ApiResponse<>("Semester updated successfully", semesterService.updateSemester(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        semesterService.deleteSemester(id);
        return new ApiResponse<>("Semester deleted successfully", null);
    }
}
