package com.example.university_management.modules.Subject.Controller;

import com.example.university_management.modules.Subject.Entity.Subject;
import com.example.university_management.modules.Subject.Repository.SubjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TableSubject")

public class SubjectController {
    private final SubjectRepository subjectRepository;

    public SubjectController (SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @GetMapping
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }
}
