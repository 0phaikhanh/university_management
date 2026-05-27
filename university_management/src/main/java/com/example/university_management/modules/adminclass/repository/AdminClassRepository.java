package com.example.university_management.modules.adminclass.repository;

import com.example.university_management.modules.adminclass.entity.AdminClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminClassRepository extends JpaRepository<AdminClass, String> {

}
