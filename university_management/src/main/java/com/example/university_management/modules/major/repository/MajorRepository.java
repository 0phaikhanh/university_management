package com.example.university_management.modules.major.repository;

import com.example.university_management.modules.major.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, String> {
}
