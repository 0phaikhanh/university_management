package com.example.university_management.modules.subject.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SubjectRequestDTO {
    @NotBlank(message = "Subject ID is required")
    @Size(max = 50, message = "Subject ID must not exceed 50 characters")
    private String subjectId;

    @NotBlank(message = "Subject name is required")
    @Size(max = 255, message = "Subject name must not exceed 255 characters")
    private String subjectName;

    @NotNull(message = "Total credits is required")
    @Min(value = 0, message = "Total credits must be greater than or equal to 0")
    private Integer totalCredits;

    @NotNull(message = "Theory credits is required")
    @Min(value = 0, message = "Theory credits must be greater than or equal to 0")
    private Integer theoryCredits;

    @NotNull(message = "Practice credits is required")
    @Min(value = 0, message = "Practice credits must be greater than or equal to 0")
    private Integer practiceCredits;
}
