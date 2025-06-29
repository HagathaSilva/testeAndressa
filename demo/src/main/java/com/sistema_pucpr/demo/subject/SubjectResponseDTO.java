package com.sistema_pucpr.demo.subject;

public record SubjectResponseDTO(Integer id, String name, Double price) {
    public SubjectResponseDTO(Subject subject) {
        this(subject.getId(), subject.getName(), subject.getPrice());
    }
}