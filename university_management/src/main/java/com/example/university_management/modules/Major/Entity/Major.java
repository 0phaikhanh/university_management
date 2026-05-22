package com.example.university_management.modules.Major.Entity;

import com.example.university_management.modules.faculty.entity.Faculty;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
