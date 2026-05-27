package com.example.university_management.modules.tuition_detail.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tuition_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TuitionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tuition_detail_id")
    private Long tuitionDetailId;

    @Column(name = "tuition_id")
    private Long tuitionId;

    @Column(name = "subject_id", length = 50)
    private String subjectId;

    @Column(name = "credits")
    private Integer credits;

    @Column(name = "amount", precision = 12, scale = 2)
    private BigDecimal amount;
}
