package com.example.university_management.modules.student_course_result.repository;

import com.example.university_management.modules.student_course_result.Entity.StudentCourseResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentCourseResultRepository extends JpaRepository<StudentCourseResult, Long> {
    Optional<StudentCourseResult> findByStudentIdAndCourseClassId(String studentId, String courseClassId);
}
