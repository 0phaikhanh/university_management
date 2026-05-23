package com.example.university_management.modules.trainingprogram.service;

import com.example.university_management.modules.trainingprogram.dto.TrainingProgramRequestDTO;
import com.example.university_management.modules.trainingprogram.entity.TrainingProgram;
import java.util.List;

public interface TrainingProgramService {
    List<TrainingProgram> getAllPrograms();
    TrainingProgram getProgramById(String id);
    TrainingProgram createProgram(TrainingProgramRequestDTO dto);
    TrainingProgram updateProgram(String id, TrainingProgramRequestDTO dto);
    void deleteProgram(String id);
}