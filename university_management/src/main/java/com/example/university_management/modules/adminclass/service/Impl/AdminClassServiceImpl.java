package com.example.university_management.modules.adminclass.service.impl;

import com.example.university_management.modules.adminclass.dto.AdminClassRequestDTO;
import com.example.university_management.modules.adminclass.entity.AdminClass;
import com.example.university_management.modules.adminclass.repository.AdminClassRepository;
import com.example.university_management.modules.adminclass.service.AdminClassService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminClassServiceImpl implements AdminClassService {

    private final AdminClassRepository adminClassRepository;

    // Chỉ cần inject duy nhất AdminClassRepository
    public AdminClassServiceImpl(AdminClassRepository adminClassRepository) {
        this.adminClassRepository = adminClassRepository;
    }

    @Override
    public List<AdminClass> getAllClasses() {
        return adminClassRepository.findAll();
    }

    @Override
    public AdminClass getClassById(String id) {
        return adminClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lớp hành chính với ID: " + id));
    }

    @Override
    public AdminClass createClass(AdminClassRequestDTO dto) {
        if (adminClassRepository.existsById(dto.getClassId())) {
            throw new RuntimeException("Mã lớp hành chính đã tồn tại!");
        }

        // Nên check majorRepository.existsById ở đây

        AdminClass adminClass = AdminClass.builder()
                .classId(dto.getClassId())
                .majorId(dto.getMajorId()) // Người dùng truyền lên chuỗi gì thì lưu chuỗi đó
                .entranceYear(dto.getEntranceYear())
                .build();

        return adminClassRepository.save(adminClass);
    }

    @Override
    public AdminClass updateClass(String id, AdminClassRequestDTO dto) {
        AdminClass existingClass = adminClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lớp hành chính để cập nhật!"));

        // Nên check majorRepository.existsById ở đây

        existingClass.setMajorId(dto.getMajorId());
        existingClass.setEntranceYear(dto.getEntranceYear());

        return adminClassRepository.save(existingClass);
    }

    @Override
    public void deleteClass(String id) {
        AdminClass existingClass = adminClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lớp hành chính để xóa!"));
        adminClassRepository.delete(existingClass);
    }
}