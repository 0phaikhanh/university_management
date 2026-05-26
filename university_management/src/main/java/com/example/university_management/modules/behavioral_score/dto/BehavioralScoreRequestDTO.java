package com.example.university_management.modules.behavioral_score.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BehavioralScoreRequestDTO {

    @NotBlank(message = "Student ID is required")
    @Size(max = 50, message = "Student ID must not exceed 50 characters")
    private String studentId;

    @NotBlank(message = "Semester ID is required")
    @Size(max = 50, message = "Semester ID must not exceed 50 characters")
    private String semesterId;

    @NotNull(message = "Behavioral score is required")
    @Min(value = 0, message = "Behavioral score must be at least 0")
    @Max(value = 100, message = "Behavioral score must be at most 100")
    private Integer totalPoints;

    @NotBlank(message = "Classification is required")
    @Size(max = 50, message = "Classification must not exceed 50 characters")
    private String classification;
}
