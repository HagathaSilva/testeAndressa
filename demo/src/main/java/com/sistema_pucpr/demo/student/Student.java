package com.sistema_pucpr.demo.student;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "student")
@Entity(name = "student")
@Getter // ← ESSE AQUI É FUNDAMENTAL!
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Student(StudentRequestDTO data) {
        this.name = data.name();
    }
}
