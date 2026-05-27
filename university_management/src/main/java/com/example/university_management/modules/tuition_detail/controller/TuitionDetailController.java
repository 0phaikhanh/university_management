package com.example.university_management.modules.tuition_detail.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.tuition_detail.dto.TuitionDetailRequestDTO;
import com.example.university_management.modules.tuition_detail.entity.TuitionDetail;
import com.example.university_management.modules.tuition_detail.service.TuitionDetailService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tuition-details")
public class TuitionDetailController {

    private final TuitionDetailService detailService;

    public TuitionDetailController(TuitionDetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping
    public ApiResponse<PageResponse<TuitionDetail>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "tuitionDetailId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<TuitionDetail> detailPage = detailService.getAllTuitionDetails(pageable);
        return new ApiResponse<>("Tuition details retrieved successfully", PageResponse.of(detailPage));
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
