package com.example.university_management.modules.tuition.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.tuition.dto.TuitionRequestDTO;
import com.example.university_management.modules.tuition.entity.Tuition;
import com.example.university_management.modules.tuition.repository.TuitionRepository;
import com.example.university_management.modules.tuition.service.TuitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TuitionServiceImpl implements TuitionService {

    private final TuitionRepository tuitionRepository;

    public TuitionServiceImpl(TuitionRepository tuitionRepository) {
        this.tuitionRepository = tuitionRepository;
    }

    @Override
    public Page<Tuition> getAllTuitions(Pageable pageable) {
        return tuitionRepository.findAll(pageable);
    }

    @Override
    public Tuition getTuitionById(Long id) {
        return tuitionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tuition not found with ID: " + id));
    }

    @Override
    public Tuition createTuition(TuitionRequestDTO dto) {
        // Check duplicate UNIQUE constraint (student_id, semester_id)
        tuitionRepository.findByStudentIdAndSemesterId(dto.getStudentId(), dto.getSemesterId())
                .ifPresent(t -> {
                    throw new RuntimeException("Tuition for this student and semester has already been created!");
                });

        Tuition tuition = Tuition.builder()
                .studentId(dto.getStudentId())
                .semesterId(dto.getSemesterId())
                .totalFee(dto.getTotalFee())
                .discountAmount(dto.getDiscountAmount())
                .paidAmount(dto.getPaidAmount())
                .status(dto.getStatus())
                .build();

        return tuitionRepository.save(tuition);
    }

    @Override
    public Tuition updateTuition(Long id, TuitionRequestDTO dto) {
        Tuition existing = tuitionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tuition to update was not found!"));

        existing.setStudentId(dto.getStudentId());
        existing.setSemesterId(dto.getSemesterId());
        existing.setTotalFee(dto.getTotalFee());
        existing.setDiscountAmount(dto.getDiscountAmount());
        existing.setPaidAmount(dto.getPaidAmount());
        existing.setStatus(dto.getStatus());

        return tuitionRepository.save(existing);
    }

    @Override
    public void deleteTuition(Long id) {
        Tuition existing = tuitionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tuition to delete was not found!"));
        tuitionRepository.delete(existing);
    }
}
