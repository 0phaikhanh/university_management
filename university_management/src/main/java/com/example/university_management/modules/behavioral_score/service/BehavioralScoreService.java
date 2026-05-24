package com.example.university_management.modules.behavioral_score.service;

import com.example.university_management.modules.behavioral_score.dto.BehavioralScoreRequestDTO;
import com.example.university_management.modules.behavioral_score.entity.BehavioralScore;
import java.util.List;

public interface BehavioralScoreService {
    List<BehavioralScore> getAllScores();
    BehavioralScore getScoreById(Long id);
    BehavioralScore createScore(BehavioralScoreRequestDTO dto);
    BehavioralScore updateScore(Long id, BehavioralScoreRequestDTO dto);
    void deleteScore(Long id);
}
