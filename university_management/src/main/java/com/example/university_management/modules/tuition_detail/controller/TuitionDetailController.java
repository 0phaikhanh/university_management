package com.example.university_management.modules.tuition_detail.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.modules.tuition_detail.dto.TuitionDetailRequestDTO;
import com.example.university_management.modules.tuition_detail.entity.TuitionDetail;
import com.example.university_management.modules.tuition_detail.service.TuitionDetailService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tuition-details")
public class TuitionDetailController {

    private final TuitionDetailService detailService;

    public TuitionDetailController(TuitionDetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping
    public ApiResponse<List<TuitionDetail>> getAll() {
        return new ApiResponse<>("Tuition details retrieved successfully", detailService.getAllTuitionDetails());
    }

    @GetMapping("/{id}")
    public ApiResponse<TuitionDetail> getById(@PathVariable Long id) {
        return new ApiResponse<>("Tuition detail retrieved successfully", detailService.getTuitionDetailById(id));
    }

    @PostMapping
    public ApiResponse<TuitionDetail> create(@Valid @RequestBody TuitionDetailRequestDTO dto) {
        return new ApiResponse<>("Course added to tuition detail successfully", detailService.createTuitionDetail(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<TuitionDetail> update(@PathVariable Long id, @Valid @RequestBody TuitionDetailRequestDTO dto) {
        return new ApiResponse<>("Tuition detail updated successfully", detailService.updateTuitionDetail(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        detailService.deleteTuitionDetail(id);
        return new ApiResponse<>("Course removed from tuition detail successfully", null);
    }
}
