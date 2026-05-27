package com.example.university_management.modules.tuition_detail.service;

import com.example.university_management.modules.tuition_detail.dto.TuitionDetailRequestDTO;
import com.example.university_management.modules.tuition_detail.entity.TuitionDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TuitionDetailService {
    Page<TuitionDetail> getAllTuitionDetails(Pageable pageable);
    TuitionDetail getTuitionDetailById(Long id);
    TuitionDetail createTuitionDetail(TuitionDetailRequestDTO dto);
    TuitionDetail updateTuitionDetail(Long id, TuitionDetailRequestDTO dto);
    void deleteTuitionDetail(Long id);
}
