package com.example.university_management.modules.adminclass.controller;

import com.example.university_management.modules.adminclass.dto.AdminClassRequestDTO;
import com.example.university_management.modules.adminclass.entity.AdminClass;
import com.example.university_management.modules.adminclass.service.AdminClassService;
import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin-classes")
public class AdminClassController {

    private final AdminClassService adminClassService;

    public AdminClassController(AdminClassService adminClassService) {
        this.adminClassService = adminClassService;
    }

    @GetMapping
    public ApiResponse<PageResponse<AdminClass>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "classId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<AdminClass> adminClassPage = adminClassService.getAllClasses(pageable);
        return new ApiResponse<>("Admin classes retrieved successfully", PageResponse.of(adminClassPage));
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
