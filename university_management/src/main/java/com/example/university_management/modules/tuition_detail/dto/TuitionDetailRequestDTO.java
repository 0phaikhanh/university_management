package com.example.university_management.modules.tuition_detail.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TuitionDetailRequestDTO {

    @NotNull(message = "Tuition ID is required")
    private Long tuitionId;

    @NotBlank(message = "Course ID is required")
    @Size(max = 50, message = "Course ID must not exceed 50 characters")
    private String subjectId;

    @NotNull(message = "Credit count is required")
    @Min(value = 1, message = "Credit count must be greater than 0")
    private Integer credits;

    @NotNull(message = "Course amount is required")
    @DecimalMin(value = "0.0", message = "Amount must not be less than 0")
    private BigDecimal amount;
}
