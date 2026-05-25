package com.example.university_management.modules.subject.service;

import com.example.university_management.modules.subject.entity.Subject;
import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubject();
    Subject getSubjectById(String id);
    Subject createSubject(Subject subject);
    Subject updateSubject(String id, Subject subject);
    void deleteSubject(String id);
}
