package com.example.university_management.modules.tuition.controller;

import com.example.university_management.modules.tuition.common.ApiResponse;
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
        return new ApiResponse<>("Lấy danh sách học phí thành công", tuitionService.getAllTuitions());
    }

    @GetMapping("/{id}")
    public ApiResponse<Tuition> getById(@PathVariable Long id) {
        return new ApiResponse<>("Lấy thông tin học phí thành công", tuitionService.getTuitionById(id));
    }

    @PostMapping
    public ApiResponse<Tuition> create(@Valid @RequestBody TuitionRequestDTO dto) {
        return new ApiResponse<>("Khởi tạo học phí thành công", tuitionService.createTuition(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<Tuition> update(@PathVariable Long id, @Valid @RequestBody TuitionRequestDTO dto) {
        return new ApiResponse<>("Cập nhật học phí thành công", tuitionService.updateTuition(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        tuitionService.deleteTuition(id);
        return new ApiResponse<>("Xóa thông tin học phí thành công", null);
    }
}
