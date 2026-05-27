package com.example.university_management.modules.behavioral_score.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "behavioral_score")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BehavioralScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "behavioral_score_id")
    private Long behavioralScoreId;

    @Column(name = "student_id", length = 50)
    private String studentId;

    @Column(name = "semester_id", length = 50)
    private String semesterId;

    @Column(name = "total_points")
    private Integer totalPoints;

    @Column(name = "classification", length = 50)
    private String classification;
}
