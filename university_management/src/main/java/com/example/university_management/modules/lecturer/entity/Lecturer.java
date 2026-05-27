package com.example.university_management.modules.lecturer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecturer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecturer {

    @Id
    @Column(name = "lecturer_id", length = 50)
    private String lecturerId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "faculty_id", length = 50)
    private String facultyId;
}
