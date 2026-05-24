package com.example.university_management.modules.behavioral_score.controller;

import com.example.university_management.modules.behavioral_score.common.ApiResponse;
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
        return new ApiResponse<>("Lấy danh sách điểm rèn luyện thành công", scoreService.getAllScores());
    }

    @GetMapping("/{id}")
    public ApiResponse<BehavioralScore> getById(@PathVariable Long id) {
        return new ApiResponse<>("Lấy điểm rèn luyện thành công", scoreService.getScoreById(id));
    }

    @PostMapping
    public ApiResponse<BehavioralScore> create(@Valid @RequestBody BehavioralScoreRequestDTO dto) {
        return new ApiResponse<>("Thêm điểm rèn luyện thành công", scoreService.createScore(dto));
    }

    @PutMapping("/{id}")
    public ApiResponse<BehavioralScore> update(@PathVariable Long id, @Valid @RequestBody BehavioralScoreRequestDTO dto) {
        return new ApiResponse<>("Cập nhật điểm rèn luyện thành công", scoreService.updateScore(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return new ApiResponse<>("Xóa điểm rèn luyện thành công", null);
    }
}
