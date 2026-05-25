package com.example.university_management.modules.course_class.dto;

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
public class CourseClassRequestDTO {

    @NotBlank(message = "Mã lớp học phần không được để trống")
    @Size(max = 50, message = "Mã lớp học phần tối đa 50 ký tự")
    private String courseClassId;

    @NotBlank(message = "Mã môn học không được để trống")
    @Size(max = 50, message = "Mã môn học tối đa 50 ký tự")
    private String subjectId;

    @NotBlank(message = "Mã học kỳ không được để trống")
    @Size(max = 50, message = "Mã học kỳ tối đa 50 ký tự")
    private String semesterId;

    @Size(max = 50, message = "Mã giảng viên tối đa 50 ký tự")
    private String lecturerId;

    @NotNull(message = "Sĩ số tối đa không được để trống")
    @Min(value = 1, message = "Sĩ số tối đa phải lớn hơn 0")
    private Integer maxCapacity;

    @Size(max = 255, message = "Lịch học tối đa 255 ký tự")
    private String schedule;

    @Size(max = 50, message = "Phòng học tối đa 50 ký tự")
    private String room;
}
