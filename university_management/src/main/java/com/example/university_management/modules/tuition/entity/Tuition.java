package com.example.university_management.modules.tuition.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tuition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tuition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tuition_id")
    private Long tuitionId;

    @Column(name = "student_id", length = 50)
    private String studentId;

    @Column(name = "semester_id", length = 50)
    private String semesterId;

    @Column(name = "total_fee", precision = 12, scale = 2)
    private BigDecimal totalFee;

    @Column(name = "discount_amount", precision = 12, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "paid_amount", precision = 12, scale = 2)
    private BigDecimal paidAmount;

    @Column(name = "status", length = 50)
    private String status;
}