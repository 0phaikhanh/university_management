package com.example.university_management.modules.student_course_result.controller;

import com.example.university_management.modules.student_course_result.Entity.StudentCourseResult;
import com.example.university_management.modules.student_course_result.common.ApiResponse;
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
        return new ApiResponse<>("Lấy danh sách điểm học phần thành công", resultService.getAllResults());
    }

    @GetMapping("/{id}")
    public ApiResponse<StudentCourseResult> getById(@PathVariable Long id) {
        return new ApiResponse<>("Lấy điểm học phần thành công", resultService.getResultById(id));
    }

    @PostMapping
    public ApiResponse<StudentCourseResult> create(@Valid @RequestBody StudentCourseResultRequestDTO dto) {
        return new ApiResponse<>("Nhập điểm học phần thành công", resultService.createResult(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentCourseResult> update(@PathVariable Long id, @Valid @RequestBody StudentCourseResultRequestDTO dto) {
        return new ApiResponse<>("Cập nhật điểm học phần thành công", resultService.updateResult(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        resultService.deleteResult(id);
        return new ApiResponse<>("Xóa điểm học phần thành công", null);
    }
}
