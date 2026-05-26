package com.example.university_management.modules.adminclass.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin_class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminClass {

    @Id
    @Column(name = "class_id", length = 50)
    private String classId;

    @Column(name = "major_id", length = 50)
    private String majorId;

    @Column(name = "entrance_year")
    private Integer entranceYear;
}
