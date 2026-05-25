package com.example.university_management.modules.program_subject.controller;

import com.example.university_management.modules.program_subject.entity.ProgramSubject;
import com.example.university_management.modules.program_subject.entity.ProgramSubjectId;
import com.example.university_management.modules.program_subject.service.ProgramSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/program-subject")
@RequiredArgsConstructor

public class ProgramSubjectControllder {
    private final ProgramSubjectService programSubjectService;

    @GetMapping
    public List<ProgramSubject> getAll(){
        return programSubjectService.getAllProgramSubject();
    }

    @GetMapping("/{programId}/{subjectId}")
    public ProgramSubject getById(@PathVariable ProgramSubjectId id){
        return programSubjectService.getProgramSubjectById(id);
    }

    @PostMapping
    public ProgramSubject create(@RequestBody ProgramSubject programSubject){
        return programSubjectService.createProgramSubject(programSubject);
    }

    @PutMapping("/{id}")
    public ProgramSubject update(@PathVariable ProgramSubjectId id, @RequestBody ProgramSubject programSubject){
        return programSubjectService.updateProgramSubject(id, programSubject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ProgramSubjectId id){
        programSubjectService.deleteProgramSubject(id);
    }
}
