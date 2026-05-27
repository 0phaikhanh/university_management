package com.example.university_management.modules.student_course_result.service;

import com.example.university_management.modules.student_course_result.Entity.StudentCourseResult;
import com.example.university_management.modules.student_course_result.dto.StudentCourseResultRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentCourseResultService {
    Page<StudentCourseResult> getAllResults(Pageable pageable);
    StudentCourseResult getResultById(Long id);
    StudentCourseResult createResult(StudentCourseResultRequestDTO dto);
    StudentCourseResult updateResult(Long id, StudentCourseResultRequestDTO dto);
    void deleteResult(Long id);
}
