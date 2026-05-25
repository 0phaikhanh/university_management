package com.example.university_management.modules.subject.service.impl;

import com.example.university_management.modules.subject.entity.Subject;
import com.example.university_management.modules.subject.repository.SubjectRepository;
import com.example.university_management.modules.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SubjectRepositoryImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(String id){
        return subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject not found!"));
    }

    @Override
    public Subject createSubject(Subject subject){
        if(subjectRepository.existsById(subject.getSubjectId())){
            throw new RuntimeException("Subject already exists");
        }
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(String id, Subject subject){
        Subject existing =  subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));

        existing.setSubjectName(subject.getSubjectName());
        existing.setTotalCredits(subject.getTotalCredits());
        existing.setTheoryCredits(subject.getTheoryCredits());
        existing.setPracticeCredits(subject.getPracticeCredits());
        return subjectRepository.save(existing);
    }

    @Override
    public void deleteSubject(String id){
        Subject existing = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));
        subjectRepository.delete(existing);
    }
}
