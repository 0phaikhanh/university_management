package com.example.university_management.modules.trainingprogram.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "training_program")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingProgram {

    @Id
    @Column(name = "program_id", length = 50)
    private String programId;

    // NOTE: Loose foreign-key reference stored as String
    @Column(name = "major_id", length = 50)
    private String majorId;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "required_credits_to_graduate")
    private Integer requiredCreditsToGraduate;
}
