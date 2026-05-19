package com.example.university_management.modules.student.entity;

import com.example.university_management.modules.adminclass.entity.AdminClass;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter                 // Tự động sinh tất cả các hàm get
@Setter                 // Tự động sinh tất cả các hàm set
@NoArgsConstructor      // Tự động sinh Constructor không tham số (bắt buộc cho JPA)
@AllArgsConstructor     // Tự động sinh Constructor có đầy đủ tham số (tiện khi tạo nhanh đối tượng)
@Builder                // Giúp tạo đối tượng theo Design Pattern Builder rất chuyên nghiệp
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
