package com.example.university_management.modules.semester.service.impl;

import com.example.university_management.modules.semester.dto.SemesterRequestDTO;
import com.example.university_management.modules.semester.entity.Semester;
import com.example.university_management.modules.semester.repository.SemesterRepository;
import com.example.university_management.modules.semester.service.SemesterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public Page<Semester> getAllSemesters(Pageable pageable) {
        return semesterRepository.findAll(pageable);
    }

    @Override
    public Semester getSemesterById(String id) {
        return semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semester not found with ID: " + id));
    }

    @Override
    public Semester createSemester(SemesterRequestDTO dto) {
        if (semesterRepository.existsById(dto.getSemesterId())) {
            throw new RuntimeException("Semester ID already exists!");
        }

        // Validate date logic: end date must be after start date
        if (dto.getEndDate().isBefore(dto.getStartDate())) {
            throw new RuntimeException("End date must be after start date!");
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
                .orElseThrow(() -> new RuntimeException("Semester to update was not found!"));

        // Validate date logic
        if (dto.getEndDate().isBefore(dto.getStartDate())) {
            throw new RuntimeException("End date must be after start date!");
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
                .orElseThrow(() -> new RuntimeException("Semester to delete was not found!"));
        semesterRepository.delete(existing);
    }
}
