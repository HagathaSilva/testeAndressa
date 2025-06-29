package com.sistema_pucpr.demo.controllers;

import com.sistema_pucpr.demo.subject.Subject;
import com.sistema_pucpr.demo.subject.SubjectRepository;
import com.sistema_pucpr.demo.subject.SubjectRequestDTO;
import com.sistema_pucpr.demo.subject.SubjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "*")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping
    public void saveSubject(@RequestBody SubjectRequestDTO data) {
        Subject subject = new Subject(data);
        subjectRepository.save(subject);
    }

    @GetMapping
    public List<SubjectResponseDTO> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(SubjectResponseDTO::new)
                .toList();
    }
}