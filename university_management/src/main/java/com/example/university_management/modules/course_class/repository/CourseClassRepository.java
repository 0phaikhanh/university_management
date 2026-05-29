package com.example.university_management.modules.course_class.repository;

import com.example.university_management.modules.course_class.entity.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseClassRepository extends JpaRepository<CourseClass, String> {
}
