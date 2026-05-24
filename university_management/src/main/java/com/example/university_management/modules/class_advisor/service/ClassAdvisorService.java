package com.example.university_management.modules.class_advisor.service;

import com.example.university_management.modules.class_advisor.dto.ClassAdvisorRequestDTO;
import com.example.university_management.modules.class_advisor.entity.ClassAdvisor;

import java.util.List;

public interface ClassAdvisorService {
    List<ClassAdvisor> getAllAdvisors();
    ClassAdvisor getAdvisorById(Long id);
    ClassAdvisor createAdvisor(ClassAdvisorRequestDTO dto);
    ClassAdvisor updateAdvisor(Long id, ClassAdvisorRequestDTO dto);
    void deleteAdvisor(Long id);
}
