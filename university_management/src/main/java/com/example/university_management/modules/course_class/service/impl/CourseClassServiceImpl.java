package com.example.university_management.modules.course_class.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.course_class.dto.CourseClassRequestDTO;
import com.example.university_management.modules.course_class.entity.CourseClass;
import com.example.university_management.modules.course_class.repository.CourseClassRepository;
import com.example.university_management.modules.course_class.service.CourseClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseClassServiceImpl implements CourseClassService {
    private final CourseClassRepository courseClassRepository;

    public CourseClassServiceImpl(CourseClassRepository courseClassRepository) {
        this.courseClassRepository = courseClassRepository;
    }

    @Override
    public List<CourseClass> getAllCourseClasses() {
        return courseClassRepository.findAll();
    }

    @Override
    public CourseClass getCourseClassById(String id) {
        return courseClassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy lớp học phần với ID: " + id));
    }

    @Override
    public CourseClass createCourseClass(CourseClassRequestDTO dto) {
        if (courseClassRepository.existsById(dto.getCourseClassId())) {
            throw new RuntimeException("Mã lớp học phần đã tồn tại!");
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
                .orElseThrow(() -> new NotFoundException("Không tìm thấy lớp học phần để cập nhật!"));

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
                .orElseThrow(() -> new NotFoundException("Không tìm thấy lớp học phần để xóa!"));
        courseClassRepository.delete(existing);
    }
}
