package com.example.university_management.modules.semester.service.impl;

import com.example.university_management.modules.semester.dto.SemesterRequestDTO;
import com.example.university_management.modules.semester.entity.Semester;
import com.example.university_management.modules.semester.repository.SemesterRepository;
import com.example.university_management.modules.semester.service.SemesterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    @Override
    public Semester getSemesterById(String id) {
        return semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học kỳ với ID: " + id));
    }

    @Override
    public Semester createSemester(SemesterRequestDTO dto) {
        if (semesterRepository.existsById(dto.getSemesterId())) {
            throw new RuntimeException("Mã học kỳ đã tồn tại!");
        }

        // Kiểm tra logic ngày tháng: Ngày kết thúc phải sau ngày bắt đầu
        if (dto.getEndDate().isBefore(dto.getStartDate())) {
            throw new RuntimeException("Ngày kết thúc phải sau ngày bắt đầu!");
        }

        Semester semester = Semester.builder()
                .semesterId(dto.getSemesterId())
                .academicYear(dto.getAcademicYear())
                .semesterNumber(dto.getSemesterNumber())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();

        return semesterRepository.save(semester);
    }

    @Override
    public Semester updateSemester(String id, SemesterRequestDTO dto) {
        Semester existing = semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học kỳ để cập nhật!"));

        // Kiểm tra logic ngày tháng
        if (dto.getEndDate().isBefore(dto.getStartDate())) {
            throw new RuntimeException("Ngày kết thúc phải sau ngày bắt đầu!");
        }

        existing.setAcademicYear(dto.getAcademicYear());
        existing.setSemesterNumber(dto.getSemesterNumber());
        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());

        return semesterRepository.save(existing);
    }

    @Override
    public void deleteSemester(String id) {
        Semester existing = semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học kỳ để xóa!"));
        semesterRepository.delete(existing);
    }
}