package com.sistema_pucpr.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema_pucpr.demo.student.Student;
import com.sistema_pucpr.demo.student.StudentRepository;
import com.sistema_pucpr.demo.student.StudentRequestDTO;
import com.sistema_pucpr.demo.student.StudentResponseDTO;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*") // ← AQUI NO CONTROLLER TODO
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public void savestudent(@RequestBody StudentRequestDTO data) {
        Student studentData = new Student(data);
        studentRepository.save(studentData);
    }

    @GetMapping
    public List<StudentResponseDTO> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponseDTO::new)
                .toList();
    }
}
