package com.example.university_management.modules.student_course_result.service;

import com.example.university_management.modules.student_course_result.Entity.StudentCourseResult;
import com.example.university_management.modules.student_course_result.dto.StudentCourseResultRequestDTO;

import java.util.List;

public interface StudentCourseResultService {
    List<StudentCourseResult> getAllResults();
    StudentCourseResult getResultById(Long id);
    StudentCourseResult createResult(StudentCourseResultRequestDTO dto);
    StudentCourseResult updateResult(Long id, StudentCourseResultRequestDTO dto);
    void deleteResult(Long id);
}
