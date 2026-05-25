package com.example.university_management.modules.subject.controller;

import com.example.university_management.modules.subject.entity.Subject;
import com.example.university_management.modules.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor

public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll(){
        return subjectService.getAllSubject();
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable String id){
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable String id, @RequestBody Subject subject){
        return subjectService.updateSubject(id, subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        subjectService.deleteSubject(id);
    }
}
