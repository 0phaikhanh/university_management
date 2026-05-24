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

    @NotBlank(message = "Mã sinh viên không được để trống")
    @Size(max = 50, message = "Mã sinh viên tối đa 50 ký tự")
    private String studentId;

    @NotBlank(message = "Mã học kỳ không được để trống")
    @Size(max = 50, message = "Mã học kỳ tối đa 50 ký tự")
    private String semesterId;

    @NotNull(message = "Tổng học phí không được để trống")
    @DecimalMin(value = "0.0", message = "Tổng học phí không được âm")
    private BigDecimal totalFee;

    @NotNull(message = "Số tiền miễn giảm không được để trống")
    @DecimalMin(value = "0.0", message = "Số tiền miễn giảm không được âm")
    private BigDecimal discountAmount;

    @NotNull(message = "Số tiền đã nộp không được để trống")
    @DecimalMin(value = "0.0", message = "Số tiền đã nộp không được âm")
    private BigDecimal paidAmount;

    @NotBlank(message = "Trạng thái đóng học phí không được để trống")
    @Size(max = 50, message = "Trạng thái tối đa 50 ký tự")
    private String status;
}