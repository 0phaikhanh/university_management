package com.example.university_management.modules.course_class.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course_class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseClass {

    @Id
    @Column(name = "course_class_id", length = 50)
    private String courseClassId;

    @Column(name = "subject_id", length = 50)
    private String subjectId;

    @Column(name = "semester_id", length = 50)
    private String semesterId;

    @Column(name = "lecturer_id", length = 50)
    private String lecturerId;

    @Column(name = "max_capacity")
    private Integer maxCapacity;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "room", length = 50)
    private String room;
}
