package com.example.university_management.modules.trainingprogram.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingProgramRequestDTO {

    @NotBlank(message = "Training program ID is required")
    @Size(max = 50, message = "Training program ID must not exceed 50 characters")
    private String programId;

    @NotBlank(message = "Major ID is required")
    @Size(max = 50, message = "Major ID must not exceed 50 characters")
    private String majorId;

    @NotBlank(message = "Training program name is required")
    @Size(max = 255, message = "Training program name must not exceed 255 characters")
    private String programName;

    @NotNull(message = "Required graduation credits are required")
    @Min(value = 1, message = "Required graduation credits must be greater than 0")
    private Integer requiredCreditsToGraduate;
}
