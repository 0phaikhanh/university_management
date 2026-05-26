package com.example.university_management.modules.student.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {

    @NotBlank(message = "Student ID is required")
    @Size(max = 50, message = "Student ID must not exceed 50 characters")
    private String studentId;

    @NotBlank(message = "Student name is required")
    @Size(max = 255, message = "Student name must not exceed 255 characters")
    private String fullName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required")
    @Size(max = 10, message = "Gender must not exceed 10 characters")
    private String gender;

    @NotBlank(message = "Email is required")
    @Email(message = "Email format is invalid")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number must not exceed 20 characters")
    @Pattern(regexp = "^[0-9]*$", message = "Phone number must contain digits only")
    private String phone;

    @NotBlank(message = "Admin class ID is required")
    @Size(max = 50, message = "Class ID must not exceed 50 characters")
    private String classId;

    @NotBlank(message = "Academic status is required")
    @Size(max = 50, message = "Academic status must not exceed 50 characters")
    private String academicStatus;
}