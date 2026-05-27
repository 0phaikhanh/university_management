package com.example.university_management.modules.faculty.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "faculty")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Faculty {

    @Id
    @Column(name = "faculty_id", length = 50)
    private String facultyId;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;
}