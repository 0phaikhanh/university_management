package com.example.university_management.modules.Subject.Entity;

import com.example.university_management.modules.ProgramSubject.Entity.ProgramSubject;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table( name = "subject")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Subject {
    @Id
    @Column(name = "subject_id",length = 50)
    private String subjectId;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "total_credits")
    private Integer subjectTotalCredits;

    @Column(name = "theory_credits")
    private Integer subjectTheoctyCredits;

    @Column(name = "practice_credits")
    private Integer subjectPracticeCredits;

    @OneToMany(mappedBy = "subject_id")
    private List<ProgramSubject> programSubject;
}
