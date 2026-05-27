package com.example.university_management.modules.behavioral_score.repository;

import com.example.university_management.modules.behavioral_score.entity.BehavioralScore;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BehavioralScoreRepository extends JpaRepository<BehavioralScore, Long> {
    Optional<BehavioralScore> findByStudentIdAndSemesterId(String studentId, String semesterId);
}
