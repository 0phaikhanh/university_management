package com.example.university_management.modules.program_subject.service;

import com.example.university_management.modules.program_subject.entity.ProgramSubject;
import com.example.university_management.modules.program_subject.entity.ProgramSubjectId;

import java.util.List;

public interface ProgramSubjectService {
    List<ProgramSubject> getAllProgramSubject();
    ProgramSubject getProgramSubjectById(ProgramSubjectId id);
    ProgramSubject createProgramSubject(ProgramSubject programSubject);
    ProgramSubject updateProgramSubject(ProgramSubjectId id, ProgramSubject programSubject);
    void deleteProgramSubject(ProgramSubjectId id);
}
