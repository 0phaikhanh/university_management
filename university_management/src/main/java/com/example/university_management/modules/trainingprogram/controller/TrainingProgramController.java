package com.example.university_management.modules.trainingprogram.controller;


import com.example.university_management.modules.trainingprogram.common.ApiResponse;
import com.example.university_management.modules.trainingprogram.dto.TrainingProgramRequestDTO;
import com.example.university_management.modules.trainingprogram.entity.TrainingProgram;
import com.example.university_management.modules.trainingprogram.service.TrainingProgramService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-programs")
public class TrainingProgramController {

    private final TrainingProgramService trainingProgramService;

    public TrainingProgramController(TrainingProgramService trainingProgramService) {
        this.trainingProgramService = trainingProgramService;
    }

    @GetMapping
    public ApiResponse<List<TrainingProgram>> getAll() {
        return new ApiResponse<>("Lấy danh sách chương trình đào tạo thành công", trainingProgramService.getAllPrograms());
    }

    @GetMapping("/{id}")
    public ApiResponse<TrainingProgram> getById(@PathVariable String id) {
        return new ApiResponse<>("Lấy thông tin chương trình đào tạo thành công", trainingProgramService.getProgramById(id));
    }

    @PostMapping
    public ApiResponse<TrainingProgram> create(@Valid @RequestBody TrainingProgramRequestDTO dto) {
        return new ApiResponse<>("Thêm chương trình đào tạo thành công", trainingProgramService.createProgram(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<TrainingProgram> update(@PathVariable String id, @Valid @RequestBody TrainingProgramRequestDTO dto) {
        return new ApiResponse<>("Cập nhật chương trình đào tạo thành công", trainingProgramService.updateProgram(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        trainingProgramService.deleteProgram(id);
        return new ApiResponse<>("Xóa chương trình đào tạo thành công", null);
    }
}