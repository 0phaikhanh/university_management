package com.example.university_management.modules.student_course_result.controller;

import com.example.university_management.modules.student_course_result.Entity.StudentCourseResult;
import com.example.university_management.common.ApiResponse;
import com.example.university_management.modules.student_course_result.dto.StudentCourseResultRequestDTO;
import com.example.university_management.modules.student_course_result.service.StudentCourseResultService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student-course-results")
public class StudentCourseResultController {

    private final StudentCourseResultService resultService;

    public StudentCourseResultController(StudentCourseResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ApiResponse<List<StudentCourseResult>> getAll() {
        return new ApiResponse<>("Student course results retrieved successfully", resultService.getAllResults());
    }

    @GetMapping("/{id}")
    public ApiResponse<StudentCourseResult> getById(@PathVariable Long id) {
        return new ApiResponse<>("Student course result retrieved successfully", resultService.getResultById(id));
    }

    @PostMapping
    public ApiResponse<StudentCourseResult> create(@Valid @RequestBody StudentCourseResultRequestDTO dto) {
        return new ApiResponse<>("Student course result created successfully", resultService.createResult(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentCourseResult> update(@PathVariable Long id, @Valid @RequestBody StudentCourseResultRequestDTO dto) {
        return new ApiResponse<>("Student course result updated successfully", resultService.updateResult(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        resultService.deleteResult(id);
        return new ApiResponse<>("Student course result deleted successfully", null);
    }
}
