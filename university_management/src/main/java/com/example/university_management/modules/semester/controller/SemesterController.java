package com.example.university_management.modules.semester.controller;

import com.example.university_management.modules.semester.common.ApiResponse;
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
        return new ApiResponse<>("Lấy danh sách học kỳ thành công", semesterService.getAllSemesters());
    }

    @GetMapping("/{id}")
    public ApiResponse<Semester> getById(@PathVariable String id) {
        return new ApiResponse<>("Lấy thông tin học kỳ thành công", semesterService.getSemesterById(id));
    }

    @PostMapping
    public ApiResponse<Semester> create(@Valid @RequestBody SemesterRequestDTO dto) {
        return new ApiResponse<>("Thêm học kỳ thành công", semesterService.createSemester(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Semester> update(@PathVariable String id, @Valid @RequestBody SemesterRequestDTO dto) {
        return new ApiResponse<>("Cập nhật học kỳ thành công", semesterService.updateSemester(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        semesterService.deleteSemester(id);
        return new ApiResponse<>("Xóa học kỳ thành công", null);
    }
}
