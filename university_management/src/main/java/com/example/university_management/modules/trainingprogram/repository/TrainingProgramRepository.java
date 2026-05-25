package com.example.university_management.modules.trainingprogram.repository;

import com.example.university_management.modules.trainingprogram.entity.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingProgramRepository extends JpaRepository <TrainingProgram, String> {
}
