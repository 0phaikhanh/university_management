package com.example.university_management.modules.major.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.major.dto.MajorRequestDTO;
import com.example.university_management.modules.major.entity.Major;
import com.example.university_management.modules.major.service.MajorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/major")
@RequiredArgsConstructor

public class MajorController {
    private final MajorService majorService;

    @GetMapping
    public ApiResponse<PageResponse<Major>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "majorId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir){
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<Major> majorPage = majorService.getAllMajor(pageable);
        return new ApiResponse<>("Major retrieved successfully", PageResponse.of(majorPage));
    }

    @GetMapping("/{id}")
    public ApiResponse<Major> getById(@PathVariable String id) {
        return new ApiResponse<>("Lecturer retrieved successfully", majorService.getMajorById(id));
    }

    @PostMapping
    public ApiResponse<Major> create(@Valid @RequestBody MajorRequestDTO dto) {
        return new ApiResponse<>("Lecturer created successfully", majorService.createMajor(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Major> update(@PathVariable String id, @Valid @RequestBody MajorRequestDTO dto) {
        return new ApiResponse<>("Lecturer updated successfully", majorService.updateMajor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        majorService.deleteMajor(id);
        return new ApiResponse<>("Lecturer deleted successfully", null);
    }
}
