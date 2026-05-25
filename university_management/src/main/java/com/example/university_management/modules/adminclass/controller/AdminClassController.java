package com.example.university_management.modules.adminclass.controller;

import com.example.university_management.modules.adminclass.dto.AdminClassRequestDTO;
import com.example.university_management.modules.adminclass.entity.AdminClass;
import com.example.university_management.modules.adminclass.service.AdminClassService;
import com.example.university_management.modules.student.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin-classes")
public class AdminClassController {

    private final AdminClassService adminClassService;

    public AdminClassController(AdminClassService adminClassService) {
        this.adminClassService = adminClassService;
    }

    @GetMapping
    public ApiResponse<List<AdminClass>> getAll() {
        return new ApiResponse<>("Lấy danh sách lớp thành công", adminClassService.getAllClasses());
    }

    @GetMapping("/{id}")
    public ApiResponse<AdminClass> getById(@PathVariable String id) {
        return new ApiResponse<>("Lấy thông tin lớp thành công", adminClassService.getClassById(id));
    }

    @PostMapping
    public ApiResponse<AdminClass> create(@Valid @RequestBody AdminClassRequestDTO dto) {
        return new ApiResponse<>("Tạo lớp hành chính thành công", adminClassService.createClass(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<AdminClass> update(@PathVariable String id, @Valid @RequestBody AdminClassRequestDTO dto) {
        return new ApiResponse<>("Cập nhật lớp hành chính thành công", adminClassService.updateClass(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        adminClassService.deleteClass(id);
        return new ApiResponse<>("Xóa lớp hành chính thành công", null);
    }
}