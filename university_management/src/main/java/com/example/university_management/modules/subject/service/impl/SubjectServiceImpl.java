package com.example.university_management.modules.subject.service.impl;

import com.example.university_management.modules.subject.dto.SubjectRequestDTO;
import com.example.university_management.modules.subject.entity.Subject;
import com.example.university_management.modules.subject.repository.SubjectRepository;
import com.example.university_management.modules.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SubjectRepositoryImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public Page<Subject> getAllSubject(Pageable pageable){
        return subjectRepository.findAll(pageable);
    }

    @Override
    public Subject getSubjectById(String id){
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));
    }

    @Override
    public Subject createSubject(SubjectRequestDTO dto){
        if(subjectRepository.existsById(dto.getSubjectId())){
            throw new RuntimeException("Subject already exists");
        }

        Subject subject = Subject.builder()
                .subjectId(dto.getSubjectId())
                .subjectName(dto.getSubjectName())
                .totalCredits(dto.getTotalCredits())
                .theoryCredits(dto.getTheoryCredits())
                .practiceCredits(dto.getPracticeCredits())
                .build();
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(String id, SubjectRequestDTO dto){
        Subject existing =  subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));

        existing.setSubjectName(dto.getSubjectName());
        existing.setTotalCredits(dto.getTotalCredits());
        existing.setTheoryCredits(dto.getTheoryCredits());
        existing.setPracticeCredits(dto.getPracticeCredits());
        return subjectRepository.save(existing);
    }

    @Override
    public void deleteSubject(String id){
        Subject existing = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));
        subjectRepository.delete(existing);
    }
}
