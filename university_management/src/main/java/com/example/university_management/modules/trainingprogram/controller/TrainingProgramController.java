package com.example.university_management.modules.trainingprogram.controller;


import com.example.university_management.common.ApiResponse;
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
        return new ApiResponse<>("Training programs retrieved successfully", trainingProgramService.getAllPrograms());
    }

    @GetMapping("/{id}")
    public ApiResponse<TrainingProgram> getById(@PathVariable String id) {
        return new ApiResponse<>("Training program retrieved successfully", trainingProgramService.getProgramById(id));
    }

    @PostMapping
    public ApiResponse<TrainingProgram> create(@Valid @RequestBody TrainingProgramRequestDTO dto) {
        return new ApiResponse<>("Training program created successfully", trainingProgramService.createProgram(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<TrainingProgram> update(@PathVariable String id, @Valid @RequestBody TrainingProgramRequestDTO dto) {
        return new ApiResponse<>("Training program updated successfully", trainingProgramService.updateProgram(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable String id) {
        trainingProgramService.deleteProgram(id);
        return new ApiResponse<>("Training program deleted successfully", null);
    }
}
