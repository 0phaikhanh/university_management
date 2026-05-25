package com.example.university_management.modules.program_subject.service.impl;

import com.example.university_management.modules.program_subject.entity.ProgramSubject;
import com.example.university_management.modules.program_subject.entity.ProgramSubjectId;
import com.example.university_management.modules.program_subject.repository.ProgramSubjectRepository;
import com.example.university_management.modules.program_subject.service.ProgramSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProgramSubjectServiceImpl implements ProgramSubjectService {
    private final ProgramSubjectRepository programSubjectRepository;

    @Override
    public List<ProgramSubject> getAllProgramSubject() {
        return programSubjectRepository.findAll();
    }

    @Override
    public ProgramSubject getProgramSubjectById(ProgramSubjectId id) {
        return programSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program_Subject not found!"));
    }

    @Override
    public ProgramSubject createProgramSubject(ProgramSubject programSubject) {
        if(programSubjectRepository.existsById(programSubject.getId())){
            throw new RuntimeException("Program_Subject already exists");
        }
        return programSubjectRepository.save(programSubject);
    }

    @Override
    public ProgramSubject updateProgramSubject(ProgramSubjectId id, ProgramSubject programSubject) {
        ProgramSubject existing = programSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program_Subject not found!"));

        existing.setIsMandatory(programSubject.getIsMandatory());
        existing.setSuggestedSemester(programSubject.getSuggestedSemester());
        return programSubjectRepository.save(existing);
    }

    @Override
    public void deleteProgramSubject(ProgramSubjectId id) {
        ProgramSubject existing = programSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program_Subject not found!"));
        programSubjectRepository.delete(existing);
    }
}
