package com.example.university_management.modules.subject.service;

import com.example.university_management.modules.subject.dto.SubjectRequestDTO;
import com.example.university_management.modules.subject.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {
    Page<Subject> getAllSubject(Pageable pageable);
    Subject getSubjectById(String id);
    Subject createSubject(SubjectRequestDTO dto);
    Subject updateSubject(String id, SubjectRequestDTO dto);
    void deleteSubject(String id);
}
