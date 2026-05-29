package com.example.university_management.modules.student.entity;

import com.example.university_management.modules.adminclass.entity.AdminClass;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter                 // Generates all getter methods
@Setter                 // Generates all setter methods
@NoArgsConstructor      // Generates a no-arguments constructor required by JPA
@AllArgsConstructor     // Generates an all-arguments constructor
@Builder                // Enables object creation with the Builder design pattern
public class Student {

    @Id
    @Column(name = "student_id", length = 50)
    private String studentId;

    @Column (name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column (name = "gender")
    private String gender;

    @Column (name = "email", unique = true)
    private String email;

    @Column (name = "phone", length = 20)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private AdminClass adminClass;

    @Column(name = "academic_status")
    private String academicStatus;
}
