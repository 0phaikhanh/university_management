package com.example.university_management.modules.student_course_result.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.student_course_result.Entity.StudentCourseResult;
import com.example.university_management.modules.student_course_result.dto.StudentCourseResultRequestDTO;
import com.example.university_management.modules.student_course_result.repository.StudentCourseResultRepository;
import com.example.university_management.modules.student_course_result.service.StudentCourseResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseResultServiceImpl implements StudentCourseResultService {

    private final StudentCourseResultRepository resultRepository;

    public StudentCourseResultServiceImpl(StudentCourseResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<StudentCourseResult> getAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public StudentCourseResult getResultById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy kết quả học phần với ID: " + id));
    }

    @Override
    public StudentCourseResult createResult(StudentCourseResultRequestDTO dto) {
        // Kiểm tra trùng ràng buộc UNIQUE (student_id, course_class_id)
        resultRepository.findByStudentIdAndCourseClassId(dto.getStudentId(), dto.getCourseClassId())
                .ifPresent(r -> {
                    throw new RuntimeException("Sinh viên đã có điểm trong lớp học phần này!");
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
                .orElseThrow(() -> new NotFoundException("Không tìm thấy kết quả học phần để cập nhật!"));

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
                .orElseThrow(() -> new NotFoundException("Không tìm thấy kết quả học phần để xóa!"));
        resultRepository.delete(existing);
    }
}
