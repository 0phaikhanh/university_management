package com.example.university_management.modules.tuition.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TuitionRequestDTO {

    @NotBlank(message = "Student ID is required")
    @Size(max = 50, message = "Student ID must not exceed 50 characters")
    private String studentId;

    @NotBlank(message = "Semester ID is required")
    @Size(max = 50, message = "Semester ID must not exceed 50 characters")
    private String semesterId;

    @NotNull(message = "Total tuition is required")
    @DecimalMin(value = "0.0", message = "Total tuition must not be negative")
    private BigDecimal totalFee;

    @NotNull(message = "Discount amount is required")
    @DecimalMin(value = "0.0", message = "Discount amount must not be negative")
    private BigDecimal discountAmount;

    @NotNull(message = "Paid amount is required")
    @DecimalMin(value = "0.0", message = "Paid amount must not be negative")
    private BigDecimal paidAmount;

    @NotBlank(message = "Tuition payment status is required")
    @Size(max = 50, message = "Status must not exceed 50 characters")
    private String status;
}