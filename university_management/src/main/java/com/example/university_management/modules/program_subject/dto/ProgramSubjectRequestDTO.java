package com.example.university_management.modules.program_subject.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProgramSubjectRequestDTO {

    @NotBlank(message = "Program_Subject ID is required")
    @Size(max = 50, message = "Program_Subject ID must not exceed 50 characters")
    private String programId;

    @NotBlank(message = "Subject ID is required")
    @Size(max = 50, message = "Subject ID must not exceed 50 characters")
    private String subjectId;

    @NotNull(message = "Mandatory status is required")
    private Integer isMandatory;

    @NotNull(message = "Suggested semester is required")
    @Min(value = 1, message = "Suggested semester must be greater than or equal to 1")
    private Integer suggestedSemester;
}