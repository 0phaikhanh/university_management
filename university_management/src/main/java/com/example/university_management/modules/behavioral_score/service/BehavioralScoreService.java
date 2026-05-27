package com.example.university_management.modules.behavioral_score.service;

import com.example.university_management.modules.behavioral_score.dto.BehavioralScoreRequestDTO;
import com.example.university_management.modules.behavioral_score.entity.BehavioralScore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BehavioralScoreService {
    Page<BehavioralScore> getAllScores(Pageable pageable);
    BehavioralScore getScoreById(Long id);
    BehavioralScore createScore(BehavioralScoreRequestDTO dto);
    BehavioralScore updateScore(Long id, BehavioralScoreRequestDTO dto);
    void deleteScore(Long id);
}
