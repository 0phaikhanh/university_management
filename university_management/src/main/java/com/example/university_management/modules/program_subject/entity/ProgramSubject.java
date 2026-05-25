package com.example.university_management.modules.program_subject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "program_subject")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProgramSubject {
    @EmbeddedId
    private ProgramSubjectId id;

//    @ManyToOne
//    @MapsId("subjectId")
//    @JoinColumn(name = "subject_id")
//    private Subject subject;

    @Column(name = "is_mandatory")
    private Integer isMandatory;

    @Column(name = "suggested_semester", length = 11)
    private Integer suggestedSemester;
}
