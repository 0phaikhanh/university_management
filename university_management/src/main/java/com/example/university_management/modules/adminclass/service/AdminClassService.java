package com.example.university_management.modules.adminclass.service;
import com.example.university_management.modules.adminclass.dto.AdminClassRequestDTO;
import com.example.university_management.modules.adminclass.entity.AdminClass;
import java.util.List;

public interface AdminClassService {
    List<AdminClass> getAllClasses();
    AdminClass getClassById(String id);
    AdminClass createClass(AdminClassRequestDTO dto);
    AdminClass updateClass(String id, AdminClassRequestDTO dto);
    void deleteClass(String id);
}
