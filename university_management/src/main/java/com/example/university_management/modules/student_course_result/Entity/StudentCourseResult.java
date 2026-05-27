package com.example.university_management.modules.student_course_result.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_course_result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCourseResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long resultId;

    @Column(name = "student_id", length = 50)
    private String studentId;

    @Column(name = "course_class_id", length = 50)
    private String courseClassId;

    @Column(name = "reg_type", length = 50)
    private String regType;

    @Column(name = "attendance_score")
    private Float attendanceScore;

    @Column(name = "midterm_score")
    private Float midtermScore;

    @Column(name = "final_score")
    private Float finalScore;

    @Column(name = "total_10")
    private Float total10;

    @Column(name = "total_4")
    private Float total4;

    @Column(name = "grade_letter", length = 5)
    private String gradeLetter;
}