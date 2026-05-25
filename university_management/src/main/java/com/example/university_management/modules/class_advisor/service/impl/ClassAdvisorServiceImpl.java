package com.example.university_management.modules.class_advisor.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.class_advisor.dto.ClassAdvisorRequestDTO;
import com.example.university_management.modules.class_advisor.entity.ClassAdvisor;
import com.example.university_management.modules.class_advisor.repository.ClassAdvisorRepository;
import com.example.university_management.modules.class_advisor.service.ClassAdvisorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassAdvisorServiceImpl implements ClassAdvisorService {
    private final ClassAdvisorRepository classAdvisorRepository;

    public ClassAdvisorServiceImpl(ClassAdvisorRepository classAdvisorRepository) {
        this.classAdvisorRepository = classAdvisorRepository;
    }

    @Override
    public List<ClassAdvisor> getAllAdvisors() {
        return classAdvisorRepository.findAll();
    }

    @Override
    public ClassAdvisor getAdvisorById(Long id) {
        return classAdvisorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy cố vấn học tập với ID: " + id));
    }

    @Override
    public ClassAdvisor createAdvisor(ClassAdvisorRequestDTO dto) {
        ClassAdvisor advisor = ClassAdvisor.builder()
                .classId(dto.getClassId())
                .lecturerId(dto.getLecturerId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
        return classAdvisorRepository.save(advisor);
    }

    @Override
    public ClassAdvisor updateAdvisor(Long id, ClassAdvisorRequestDTO dto) {
        ClassAdvisor existing = classAdvisorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy cố vấn học tập để cập nhật!"));

        existing.setClassId(dto.getClassId());
        existing.setLecturerId(dto.getLecturerId());
        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());

        return classAdvisorRepository.save(existing);
    }

    @Override
    public void deleteAdvisor(Long id) {
        ClassAdvisor existing = classAdvisorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy cố vấn học tập để xóa!"));
        classAdvisorRepository.delete(existing);
    }
}
