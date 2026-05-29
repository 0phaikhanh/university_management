package com.example.university_management.modules.lecturer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LecturerRequestDTO {

    @NotBlank(message = "Lecturer ID is required")
    @Size(max = 50, message = "Lecturer ID must not exceed 50 characters")
    private String lecturerId;

    @Size(max = 255, message = "Full name must not exceed 255 characters")
    private String fullName;

    @Email(message = "Email is invalid")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    private String email;

    @Size(max = 50, message = "Faculty ID must not exceed 50 characters")
    private String facultyId;
}
