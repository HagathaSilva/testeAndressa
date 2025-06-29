package com.sistema_pucpr.demo.enrollment;

public record EnrollmentResponseDTO(Integer id, Integer studentId, String studentName, Integer subjectId,
        String subjectName, Double subjectPrice, Boolean paid) {
    public EnrollmentResponseDTO(Enrollment enrollment) {
        this(
                enrollment.getId(),
                enrollment.getStudent().getId(),
                enrollment.getStudent().getName(),
                enrollment.getSubject().getId(),
                enrollment.getSubject().getName(),
                enrollment.getSubject().getPrice(),
                enrollment.getPaid());
    }
}