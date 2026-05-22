package com.example.university_management.modules.ProgramSubject.Controller;

import com.example.university_management.modules.ProgramSubject.Entity.ProgramSubject;
import com.example.university_management.modules.ProgramSubject.Repository.ProgramSubjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TableProgramSubject")

public class ProgramSubjectController {
    private ProgramSubjectRepository programSubjectRepository;

    public ProgramSubjectController(ProgramSubjectRepository programSubjectRepository){
        this.programSubjectRepository = programSubjectRepository;
    }

    @GetMapping
    public List<ProgramSubject> getAllProgramSubject(){
        return programSubjectRepository.findAll();
    }
}
