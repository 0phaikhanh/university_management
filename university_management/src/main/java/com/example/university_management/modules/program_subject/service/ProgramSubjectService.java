package com.example.university_management.modules.program_subject.service;

import com.example.university_management.modules.program_subject.dto.ProgramSubjectRequestDTO;
import com.example.university_management.modules.program_subject.entity.ProgramSubject;
import com.example.university_management.modules.program_subject.entity.ProgramSubjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProgramSubjectService {
    Page<ProgramSubject> getAllProgramSubject(Pageable pageable);
    ProgramSubject getProgramSubjectById(ProgramSubjectId id);
    ProgramSubject createProgramSubject(ProgramSubjectRequestDTO dto);
    ProgramSubject updateProgramSubject(ProgramSubjectId id, ProgramSubjectRequestDTO dto);
    void deleteProgramSubject(ProgramSubjectId id);
}
