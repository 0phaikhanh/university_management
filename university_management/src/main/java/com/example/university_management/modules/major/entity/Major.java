package com.example.university_management.modules.major.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "major")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Major {
    @Id
    @Column(name = "major_id", length = 50)
    private String majorId;

    @Column(name = "major_name", nullable = false)
    private String majorName;

    @Column(name = "faculty_id", length = 50)
    private String facultyId;
}
