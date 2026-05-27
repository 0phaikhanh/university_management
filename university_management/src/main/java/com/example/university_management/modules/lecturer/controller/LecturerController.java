package com.example.university_management.modules.lecturer.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.lecturer.dto.LecturerRequestDTO;
import com.example.university_management.modules.lecturer.entity.Lecturer;
import com.example.university_management.modules.lecturer.service.LecturerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lecturers")
public class LecturerController {

    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping
    public ApiResponse<PageResponse<Lecturer>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "lecturerId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<Lecturer> lecturerPage = lecturerService.getAllLecturers(pageable);
        return new ApiResponse<>("Lecturers retrieved successfully", PageResponse.of(lecturerPage));
    }

    @GetMapping("/{id}")
    public ApiResponse<Lecturer> getById(@PathVariable String id) {
        return new ApiResponse<>("Lecturer retrieved successfully", lecturerService.getLecturerById(id));
    }

    @PostMapping
    public ApiResponse<Lecturer> create(@Valid @RequestBody LecturerRequestDTO dto) {
        return new ApiResponse<>("Lecturer created successfully", lecturerService.createLecturer(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Lecturer> update(@PathVariable String id, @Valid @RequestBody LecturerRequestDTO dto) {
        return new ApiResponse<>("Lecturer updated successfully", lecturerService.updateLecturer(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        lecturerService.deleteLecturer(id);
        return new ApiResponse<>("Lecturer deleted successfully", null);
    }
}
