package com.example.university_management.modules.student_course_result.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCourseResultRequestDTO {

    @NotBlank(message = "Mã sinh viên không được để trống")
    @Size(max = 50, message = "Mã sinh viên tối đa 50 ký tự")
    private String studentId;

    @NotBlank(message = "Mã lớp học phần không được để trống")
    @Size(max = 50, message = "Mã lớp học phần tối đa 50 ký tự")
    private String courseClassId;

    @Size(max = 50, message = "Loại đăng ký tối đa 50 ký tự")
    private String regType;

    @Min(value = 0, message = "Điểm chuyên cần không được nhỏ hơn 0")
    @Max(value = 10, message = "Điểm chuyên cần không được lớn hơn 10")
    private Float attendanceScore;

    @Min(value = 0, message = "Điểm giữa kỳ không được nhỏ hơn 0")
    @Max(value = 10, message = "Điểm giữa kỳ không được lớn hơn 10")
    private Float midtermScore;

    @Min(value = 0, message = "Điểm cuối kỳ không được nhỏ hơn 0")
    @Max(value = 10, message = "Điểm cuối kỳ không được lớn hơn 10")
    private Float finalScore;

    @Min(value = 0, message = "Điểm hệ 10 không được nhỏ hơn 0")
    @Max(value = 10, message = "Điểm hệ 10 không được lớn hơn 10")
    private Float total10;

    @Min(value = 0, message = "Điểm hệ 4 không được nhỏ hơn 0")
    @Max(value = 4, message = "Điểm hệ 4 không được lớn hơn 4")
    private Float total4;

    @Size(max = 5, message = "Điểm chữ tối đa 5 ký tự")
    private String gradeLetter;
}
