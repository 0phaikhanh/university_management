package com.example.university_management.modules.behavioral_score.controller;

import com.example.university_management.common.ApiResponse;
import com.example.university_management.modules.behavioral_score.dto.BehavioralScoreRequestDTO;
import com.example.university_management.modules.behavioral_score.entity.BehavioralScore;
import com.example.university_management.modules.behavioral_score.service.BehavioralScoreService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/behavioral-scores")
public class BehavioralScoreController {

    private final BehavioralScoreService scoreService;

    public BehavioralScoreController(BehavioralScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public ApiResponse<List<BehavioralScore>> getAll() {
        return new ApiResponse<>("Behavioral scores retrieved successfully", scoreService.getAllScores());
    }

    @GetMapping("/{id}")
    public ApiResponse<BehavioralScore> getById(@PathVariable Long id) {
        return new ApiResponse<>("Behavioral score retrieved successfully", scoreService.getScoreById(id));
    }

    @PostMapping
    public ApiResponse<BehavioralScore> create(@Valid @RequestBody BehavioralScoreRequestDTO dto) {
        return new ApiResponse<>("Behavioral score created successfully", scoreService.createScore(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<BehavioralScore> update(@PathVariable Long id, @Valid @RequestBody BehavioralScoreRequestDTO dto) {
        return new ApiResponse<>("Behavioral score updated successfully", scoreService.updateScore(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return new ApiResponse<>("Behavioral score deleted successfully", null);
    }
}
