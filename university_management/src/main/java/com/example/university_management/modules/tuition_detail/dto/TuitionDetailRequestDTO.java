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

    @NotNull(message = "Mã hóa đơn học phí (tuitionId) không được để trống")
    private Long tuitionId;

    @NotBlank(message = "Mã môn học không được để trống")
    @Size(max = 50, message = "Mã môn học tối đa 50 ký tự")
    private String subjectId;

    @NotNull(message = "Số tín chỉ không được để trống")
    @Min(value = 1, message = "Số tín chỉ phải lớn hơn 0")
    private Integer credits;

    @NotNull(message = "Số tiền của môn học không được để trống")
    @DecimalMin(value = "0.0", message = "Số tiền không được nhỏ hơn 0")
    private BigDecimal amount;
}
