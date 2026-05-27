package com.example.university_management.modules.program_subject.service.impl;

import com.example.university_management.modules.program_subject.dto.ProgramSubjectRequestDTO;
import com.example.university_management.modules.program_subject.entity.ProgramSubject;
import com.example.university_management.modules.program_subject.entity.ProgramSubjectId;
import com.example.university_management.modules.program_subject.repository.ProgramSubjectRepository;
import com.example.university_management.modules.program_subject.service.ProgramSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProgramSubjectServiceImpl implements ProgramSubjectService {
    private final ProgramSubjectRepository programSubjectRepository;

    @Override
    public Page<ProgramSubject> getAllProgramSubject(Pageable pageable) {
        return programSubjectRepository.findAll(pageable);
    }

    @Override
    public ProgramSubject getProgramSubjectById(ProgramSubjectId id) {
        return programSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program_Subject not found!"));
    }

    @Override
    public ProgramSubject createProgramSubject(ProgramSubjectRequestDTO dto) {
        ProgramSubjectId id = new ProgramSubjectId(dto.getProgramId(), dto.getSubjectId());

        if(programSubjectRepository.existsById(id)){
            throw new RuntimeException("Program_Subject already exists");
        }

        ProgramSubject programSubject = ProgramSubject.builder()
                .id(id)
                .isMandatory(dto.getIsMandatory())
                .suggestedSemester(dto.getSuggestedSemester())
                .build();
        return programSubjectRepository.save(programSubject);
    }

    @Override
    public ProgramSubject updateProgramSubject(ProgramSubjectId id, ProgramSubjectRequestDTO dto) {
        ProgramSubject existing = programSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program_Subject not found!"));

        existing.setIsMandatory(dto.getIsMandatory());
        existing.setSuggestedSemester(dto.getSuggestedSemester());
        return programSubjectRepository.save(existing);
    }

    @Override
    public void deleteProgramSubject(ProgramSubjectId id) {
        ProgramSubject existing = programSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program_Subject not found!"));
        programSubjectRepository.delete(existing);
    }
}
