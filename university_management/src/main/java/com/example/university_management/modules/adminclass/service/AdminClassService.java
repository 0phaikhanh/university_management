package com.example.university_management.modules.adminclass.service;
import com.example.university_management.modules.adminclass.dto.AdminClassRequestDTO;
import com.example.university_management.modules.adminclass.entity.AdminClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminClassService {
    Page<AdminClass> getAllClasses(Pageable pageable);
    AdminClass getClassById(String id);
    AdminClass createClass(AdminClassRequestDTO dto);
    AdminClass updateClass(String id, AdminClassRequestDTO dto);
    void deleteClass(String id);
}
