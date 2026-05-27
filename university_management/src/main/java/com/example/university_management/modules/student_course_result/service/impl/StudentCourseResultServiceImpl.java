package com.example.university_management.modules.student_course_result.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.student_course_result.Entity.StudentCourseResult;
import com.example.university_management.modules.student_course_result.dto.StudentCourseResultRequestDTO;
import com.example.university_management.modules.student_course_result.repository.StudentCourseResultRepository;
import com.example.university_management.modules.student_course_result.service.StudentCourseResultService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseResultServiceImpl implements StudentCourseResultService {

    private final StudentCourseResultRepository resultRepository;

    public StudentCourseResultServiceImpl(StudentCourseResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Page<StudentCourseResult> getAllResults(Pageable pageable) {
        return resultRepository.findAll(pageable);
    }

    @Override
    public StudentCourseResult getResultById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student course result not found with ID: " + id));
    }

    @Override
    public StudentCourseResult createResult(StudentCourseResultRequestDTO dto) {
        // Check duplicate UNIQUE constraint (student_id, course_class_id)
        resultRepository.findByStudentIdAndCourseClassId(dto.getStudentId(), dto.getCourseClassId())
                .ifPresent(r -> {
                    throw new RuntimeException("This student already has a result in this course class!");
                });

        StudentCourseResult result = StudentCourseResult.builder()
                .studentId(dto.getStudentId())
                .courseClassId(dto.getCourseClassId())
                .regType(dto.getRegType())
                .attendanceScore(dto.getAttendanceScore())
                .midtermScore(dto.getMidtermScore())
                .finalScore(dto.getFinalScore())
                .total10(dto.getTotal10())
                .total4(dto.getTotal4())
                .gradeLetter(dto.getGradeLetter())
                .build();

        return resultRepository.save(result);
    }

    @Override
    public StudentCourseResult updateResult(Long id, StudentCourseResultRequestDTO dto) {
        StudentCourseResult existing = resultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student course result to update was not found!"));

        existing.setStudentId(dto.getStudentId());
        existing.setCourseClassId(dto.getCourseClassId());
        existing.setRegType(dto.getRegType());
        existing.setAttendanceScore(dto.getAttendanceScore());
        existing.setMidtermScore(dto.getMidtermScore());
        existing.setFinalScore(dto.getFinalScore());
        existing.setTotal10(dto.getTotal10());
        existing.setTotal4(dto.getTotal4());
        existing.setGradeLetter(dto.getGradeLetter());

        return resultRepository.save(existing);
    }

    @Override
    public void deleteResult(Long id) {
        StudentCourseResult existing = resultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student course result to delete was not found!"));
        resultRepository.delete(existing);
    }
}
