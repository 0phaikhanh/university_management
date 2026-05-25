package com.example.university_management.modules.tuition_detail.controller;

import com.example.university_management.modules.tuition_detail.common.ApiResponse;
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
        return new ApiResponse<>("Lấy danh sách chi tiết học phí thành công", detailService.getAllTuitionDetails());
    }

    @GetMapping("/{id}")
    public ApiResponse<TuitionDetail> getById(@PathVariable Long id) {
        return new ApiResponse<>("Lấy chi tiết học phí thành công", detailService.getTuitionDetailById(id));
    }

    @PostMapping
    public ApiResponse<TuitionDetail> create(@Valid @RequestBody TuitionDetailRequestDTO dto) {
        return new ApiResponse<>("Thêm môn học vào chi tiết học phí thành công", detailService.createTuitionDetail(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<TuitionDetail> update(@PathVariable Long id, @Valid @RequestBody TuitionDetailRequestDTO dto) {
        return new ApiResponse<>("Cập nhật chi tiết học phí môn học thành công", detailService.updateTuitionDetail(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        detailService.deleteTuitionDetail(id);
        return new ApiResponse<>("Xóa môn học khỏi chi tiết học phí thành công", null);
    }
}
