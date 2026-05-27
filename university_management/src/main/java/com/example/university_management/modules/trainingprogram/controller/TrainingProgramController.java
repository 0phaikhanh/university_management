package com.example.university_management.modules.trainingprogram.controller;


import com.example.university_management.common.ApiResponse;
import com.example.university_management.common.PageResponse;
import com.example.university_management.common.PageableUtils;
import com.example.university_management.modules.trainingprogram.dto.TrainingProgramRequestDTO;
import com.example.university_management.modules.trainingprogram.entity.TrainingProgram;
import com.example.university_management.modules.trainingprogram.service.TrainingProgramService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/training-programs")
public class TrainingProgramController {

    private final TrainingProgramService trainingProgramService;

    public TrainingProgramController(TrainingProgramService trainingProgramService) {
        this.trainingProgramService = trainingProgramService;
    }

    @GetMapping
    public ApiResponse<PageResponse<TrainingProgram>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "programId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Pageable pageable = PageableUtils.create(page, size, sortBy, sortDir);
        Page<TrainingProgram> programPage = trainingProgramService.getAllPrograms(pageable);
        return new ApiResponse<>("Training programs retrieved successfully", PageResponse.of(programPage));
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
