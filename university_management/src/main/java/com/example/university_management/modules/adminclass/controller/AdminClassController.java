package com.example.university_management.modules.adminclass.controller;

import com.example.university_management.modules.adminclass.dto.AdminClassRequestDTO;
import com.example.university_management.modules.adminclass.entity.AdminClass;
import com.example.university_management.modules.adminclass.service.AdminClassService;
import com.example.university_management.common.ApiResponse;
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
        return new ApiResponse<>("Admin classes retrieved successfully", adminClassService.getAllClasses());
    }

    @GetMapping("/{id}")
    public ApiResponse<AdminClass> getById(@PathVariable String id) {
        return new ApiResponse<>("Admin class retrieved successfully", adminClassService.getClassById(id));
    }

    @PostMapping
    public ApiResponse<AdminClass> create(@Valid @RequestBody AdminClassRequestDTO dto) {
        return new ApiResponse<>("Admin class created successfully", adminClassService.createClass(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<AdminClass> update(@PathVariable String id, @Valid @RequestBody AdminClassRequestDTO dto) {
        return new ApiResponse<>("Admin class updated successfully", adminClassService.updateClass(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        adminClassService.deleteClass(id);
        return new ApiResponse<>("Admin class deleted successfully", null);
    }
}
