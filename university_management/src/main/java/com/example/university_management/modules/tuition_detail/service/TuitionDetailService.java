package com.example.university_management.modules.tuition_detail.service;

import com.example.university_management.modules.tuition_detail.dto.TuitionDetailRequestDTO;
import com.example.university_management.modules.tuition_detail.entity.TuitionDetail;
import java.util.List;

public interface TuitionDetailService {
    List<TuitionDetail> getAllTuitionDetails();
    TuitionDetail getTuitionDetailById(Long id);
    TuitionDetail createTuitionDetail(TuitionDetailRequestDTO dto);
    TuitionDetail updateTuitionDetail(Long id, TuitionDetailRequestDTO dto);
    void deleteTuitionDetail(Long id);
}
