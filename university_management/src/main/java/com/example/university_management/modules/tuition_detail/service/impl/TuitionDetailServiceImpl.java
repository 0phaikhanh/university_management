package com.example.university_management.modules.tuition_detail.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.tuition_detail.dto.TuitionDetailRequestDTO;
import com.example.university_management.modules.tuition_detail.entity.TuitionDetail;
import com.example.university_management.modules.tuition_detail.repository.TuitionDetailRepository;
import com.example.university_management.modules.tuition_detail.service.TuitionDetailService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TuitionDetailServiceImpl implements TuitionDetailService {

    private final TuitionDetailRepository detailRepository;

    public TuitionDetailServiceImpl(TuitionDetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public List<TuitionDetail> getAllTuitionDetails() {
        return detailRepository.findAll();
    }

    @Override
    public TuitionDetail getTuitionDetailById(Long id) {
        return detailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy chi tiết học phí môn học với ID: " + id));
    }

    @Override
    public TuitionDetail createTuitionDetail(TuitionDetailRequestDTO dto) {
        TuitionDetail detail = TuitionDetail.builder()
                .tuitionId(dto.getTuitionId())
                .subjectId(dto.getSubjectId())
                .credits(dto.getCredits())
                .amount(dto.getAmount())
                .build();
        return detailRepository.save(detail);
    }

    @Override
    public TuitionDetail updateTuitionDetail(Long id, TuitionDetailRequestDTO dto) {
        TuitionDetail existing = detailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy chi tiết học phí môn học để cập nhật!"));

        existing.setTuitionId(dto.getTuitionId());
        existing.setSubjectId(dto.getSubjectId());
        existing.setCredits(dto.getCredits());
        existing.setAmount(dto.getAmount());

        return detailRepository.save(existing);
    }

    @Override
    public void deleteTuitionDetail(Long id) {
        TuitionDetail existing = detailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy chi tiết học phí môn học để xóa!"));
        detailRepository.delete(existing);
    }
}
