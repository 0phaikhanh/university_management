package com.example.university_management.modules.tuition.service;

import com.example.university_management.modules.tuition.dto.TuitionRequestDTO;
import com.example.university_management.modules.tuition.entity.Tuition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TuitionService {
    Page<Tuition> getAllTuitions(Pageable pageable);
    Tuition getTuitionById(Long id);
    Tuition createTuition(TuitionRequestDTO dto);
    Tuition updateTuition(Long id, TuitionRequestDTO dto);
    void deleteTuition(Long id);
}
