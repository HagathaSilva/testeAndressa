package com.sistema_pucpr.demo.subject;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "subject")
@Entity(name = "subject")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    public Subject(SubjectRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
    }
}