package com.example.university_management.modules.adminclass.service.Impl;

import com.example.university_management.modules.adminclass.dto.AdminClassRequestDTO;
import com.example.university_management.modules.adminclass.entity.AdminClass;
import com.example.university_management.modules.adminclass.repository.AdminClassRepository;
import com.example.university_management.modules.adminclass.service.AdminClassService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminClassServiceImpl implements AdminClassService {

    private final AdminClassRepository adminClassRepository;

    // Only AdminClassRepository needs to be injected
    public AdminClassServiceImpl(AdminClassRepository adminClassRepository) {
        this.adminClassRepository = adminClassRepository;
    }

    @Override
    public Page<AdminClass> getAllClasses(Pageable pageable) {
        return adminClassRepository.findAll(pageable);
    }

    @Override
    public AdminClass getClassById(String id) {
        return adminClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin class not found with ID: " + id));
    }

    @Override
    public AdminClass createClass(AdminClassRequestDTO dto) {
        if (adminClassRepository.existsById(dto.getClassId())) {
            throw new RuntimeException("Admin class ID already exists!");
        }

        // Consider checking majorRepository.existsById here

        AdminClass adminClass = AdminClass.builder()
                .classId(dto.getClassId())
                .majorId(dto.getMajorId()) // Store the exact string provided by the user
                .entranceYear(dto.getEntranceYear())
                .build();

        return adminClassRepository.save(adminClass);
    }

    @Override
    public AdminClass updateClass(String id, AdminClassRequestDTO dto) {
        AdminClass existingClass = adminClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin class to update was not found!"));

        // Consider checking majorRepository.existsById here

        existingClass.setMajorId(dto.getMajorId());
        existingClass.setEntranceYear(dto.getEntranceYear());

        return adminClassRepository.save(existingClass);
    }

    @Override
    public void deleteClass(String id) {
        AdminClass existingClass = adminClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin class to delete was not found!"));
        adminClassRepository.delete(existingClass);
    }
}
