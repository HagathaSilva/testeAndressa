package com.sistema_pucpr.demo.enrollment;

import com.sistema_pucpr.demo.student.Student;
import com.sistema_pucpr.demo.subject.Subject;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "enrollment")
@Entity(name = "enrollment")
@Getter
@Setter // Adicionado para permitir modificar o campo paid
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private Boolean paid;

    public Enrollment(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
        this.paid = false;
    }
}