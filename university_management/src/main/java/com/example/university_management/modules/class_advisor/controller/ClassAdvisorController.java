package com.example.university_management.modules.class_advisor.controller;

import com.example.university_management.modules.class_advisor.common.ApiResponse;
import com.example.university_management.modules.class_advisor.dto.ClassAdvisorRequestDTO;
import com.example.university_management.modules.class_advisor.entity.ClassAdvisor;
import com.example.university_management.modules.class_advisor.service.ClassAdvisorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/class-advisors")
public class ClassAdvisorController {

    private final ClassAdvisorService classAdvisorService;

    public ClassAdvisorController(ClassAdvisorService classAdvisorService) {
        this.classAdvisorService = classAdvisorService;
    }

    @GetMapping
    public ApiResponse<List<ClassAdvisor>> getAll() {
        return new ApiResponse<>("Lấy danh sách cố vấn học tập thành công", classAdvisorService.getAllAdvisors());
    }

    @GetMapping("/{id}")
    public ApiResponse<ClassAdvisor> getById(@PathVariable Long id) {
        return new ApiResponse<>("Lấy thông tin cố vấn học tập thành công", classAdvisorService.getAdvisorById(id));
    }

    @PostMapping
    public ApiResponse<ClassAdvisor> create(@Valid @RequestBody ClassAdvisorRequestDTO dto) {
        return new ApiResponse<>("Thêm cố vấn học tập thành công", classAdvisorService.createAdvisor(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<ClassAdvisor> update(@PathVariable Long id, @Valid @RequestBody ClassAdvisorRequestDTO dto) {
        return new ApiResponse<>("Cập nhật cố vấn học tập thành công", classAdvisorService.updateAdvisor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        classAdvisorService.deleteAdvisor(id);
        return new ApiResponse<>("Xóa cố vấn học tập thành công", null);
    }
}
