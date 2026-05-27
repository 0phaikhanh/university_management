package com.example.university_management.modules.course_class.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.course_class.dto.CourseClassRequestDTO;
import com.example.university_management.modules.course_class.entity.CourseClass;
import com.example.university_management.modules.course_class.repository.CourseClassRepository;
import com.example.university_management.modules.course_class.service.CourseClassService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseClassServiceImpl implements CourseClassService {
    private final CourseClassRepository courseClassRepository;

    public CourseClassServiceImpl(CourseClassRepository courseClassRepository) {
        this.courseClassRepository = courseClassRepository;
    }

    @Override
    public Page<CourseClass> getAllCourseClasses(Pageable pageable) {
        return courseClassRepository.findAll(pageable);
    }

    @Override
    public CourseClass getCourseClassById(String id) {
        return courseClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course class not found with ID: " + id));
    }

    @Override
    public CourseClass createCourseClass(CourseClassRequestDTO dto) {
        if (courseClassRepository.existsById(dto.getCourseClassId())) {
            throw new RuntimeException("Course class ID already exists!");
        }

        CourseClass courseClass = CourseClass.builder()
                .courseClassId(dto.getCourseClassId())
                .subjectId(dto.getSubjectId())
                .semesterId(dto.getSemesterId())
                .lecturerId(dto.getLecturerId())
                .maxCapacity(dto.getMaxCapacity())
                .schedule(dto.getSchedule())
                .room(dto.getRoom())
                .build();

        return courseClassRepository.save(courseClass);
    }

    @Override
    public CourseClass updateCourseClass(String id, CourseClassRequestDTO dto) {
        CourseClass existing = courseClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course class to update was not found!"));

        existing.setSubjectId(dto.getSubjectId());
        existing.setSemesterId(dto.getSemesterId());
        existing.setLecturerId(dto.getLecturerId());
        existing.setMaxCapacity(dto.getMaxCapacity());
        existing.setSchedule(dto.getSchedule());
        existing.setRoom(dto.getRoom());

        return courseClassRepository.save(existing);
    }

    @Override
    public void deleteCourseClass(String id) {
        CourseClass existing = courseClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course class to delete was not found!"));
        courseClassRepository.delete(existing);
    }
}
