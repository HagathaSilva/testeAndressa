package com.sistema_pucpr.demo.student;

public record StudentResponseDTO(Integer id, String name) {
    public StudentResponseDTO(Student student) {
        this(student.getId(), student.getName());

    }

}
