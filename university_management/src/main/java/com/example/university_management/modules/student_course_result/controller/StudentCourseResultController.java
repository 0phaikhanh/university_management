package com.example.university_management.modules.student_course_result.controller;

import com.example.university_management.modules.student_course_result.Entity.StudentCourseResult;
import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.student_course_result.dto.StudentCourseResultRequestDTO;
import com.example.university_management.modules.student_course_result.service.StudentCourseResultService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-course-results")
public class StudentCourseResultController {

    private final StudentCourseResultService resultService;

    public StudentCourseResultController(StudentCourseResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ApiResponse<PageResponse<StudentCourseResult>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "resultId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<StudentCourseResult> resultPage = resultService.getAllResults(pageable);
        return new ApiResponse<>("Student course results retrieved successfully", PageResponse.of(resultPage));
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
