package com.example.university_management.modules.tuition.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.modules.tuition.dto.TuitionRequestDTO;
import com.example.university_management.modules.tuition.entity.Tuition;
import com.example.university_management.modules.tuition.service.TuitionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tuitions")
public class TuitionController {

    private final TuitionService tuitionService;

    public TuitionController(TuitionService tuitionService) {
        this.tuitionService = tuitionService;
    }

    @GetMapping
    public ApiResponse<List<Tuition>> getAll() {
        return new ApiResponse<>("Tuition list retrieved successfully", tuitionService.getAllTuitions());
    }

    @GetMapping("/{id}")
    public ApiResponse<Tuition> getById(@PathVariable Long id) {
        return new ApiResponse<>("Tuition retrieved successfully", tuitionService.getTuitionById(id));
    }

    @PostMapping
    public ApiResponse<Tuition> create(@Valid @RequestBody TuitionRequestDTO dto) {
        return new ApiResponse<>("Tuition created successfully", tuitionService.createTuition(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Tuition> update(@PathVariable Long id, @Valid @RequestBody TuitionRequestDTO dto) {
        return new ApiResponse<>("Tuition updated successfully", tuitionService.updateTuition(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        tuitionService.deleteTuition(id);
        return new ApiResponse<>("Tuition deleted successfully", null);
    }
}
