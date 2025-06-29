package com.sistema_pucpr.demo.controllers;

import com.sistema_pucpr.demo.enrollment.Enrollment;
import com.sistema_pucpr.demo.enrollment.EnrollmentRepository;
import com.sistema_pucpr.demo.enrollment.EnrollmentRequestDTO;
import com.sistema_pucpr.demo.enrollment.EnrollmentResponseDTO;
import com.sistema_pucpr.demo.student.Student;
import com.sistema_pucpr.demo.student.StudentRepository;
import com.sistema_pucpr.demo.subject.Subject;
import com.sistema_pucpr.demo.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping
    public ResponseEntity<?> createEnrollment(@RequestBody EnrollmentRequestDTO data) {
        // Verifica se o aluno existe
        Student student = studentRepository.findById(data.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        // Verifica se a matéria existe
        Subject subject = subjectRepository.findById(data.subjectId())
                .orElseThrow(() -> new IllegalArgumentException("Matéria não encontrada"));

        // Cria a matrícula
        Enrollment enrollment = new Enrollment(student, subject);
        enrollmentRepository.save(enrollment);

        return ResponseEntity.ok(new EnrollmentResponseDTO(enrollment));
    }

    @GetMapping
    public List<EnrollmentResponseDTO> getAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(EnrollmentResponseDTO::new)
                .toList();
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<?> payEnrollment(@PathVariable Integer id) {
        // Busca a matrícula
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matrícula não encontrada"));

        // Marca como pago
        enrollment.setPaid(true);
        enrollmentRepository.save(enrollment);

        return ResponseEntity.ok(new EnrollmentResponseDTO(enrollment));
    }
}