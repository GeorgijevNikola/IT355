package com.studentsystem.studentsystem.controller;

import com.studentsystem.studentsystem.entity.Prijava;
import com.studentsystem.studentsystem.entity.Student;
import com.studentsystem.studentsystem.entity.Kurs;
import com.studentsystem.studentsystem.repository.KursRepository;
import com.studentsystem.studentsystem.repository.StudentRepository;
import com.studentsystem.studentsystem.service.PrijavaService;
import com.studentsystem.studentsystem.service.StudentService;
import com.studentsystem.studentsystem.service.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prijave")
public class PrijavaController {

    @Autowired
    private PrijavaService prijavaService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private KursRepository kursRepository;

    @GetMapping
    public List<Prijava> getAllPrijave() {
        return prijavaService.getAllPrijave();
    }

    @GetMapping("/{id}")
    public Prijava getPrijavaById(@PathVariable int id) {
        return prijavaService.getPrijavaById(id);
    }

    @PostMapping
    public void saveOrUpdatePrijava(@RequestBody Prijava prijava) {
        if (prijava.getStudent() == null || prijava.getKurs() == null) {
            throw new RuntimeException("Student i Kurs ne mogu biti null");
        }
        if (!studentRepository.existsById(prijava.getStudent().getStudentId())) {
            throw new RuntimeException("Student sa ID " + prijava.getStudent().getStudentId() + " ne postoji");
        }
        if (!kursRepository.existsById(prijava.getKurs().getKursId())) {
            throw new RuntimeException("Kurs sa ID " + prijava.getKurs().getKursId() + " ne postoji");
        }
        if (prijavaService.existsByStudentAndKurs(prijava.getStudent().getStudentId(), (long) prijava.getKurs().getKursId())) {
            throw new RuntimeException("Student je već prijavljen na ovaj kurs");
        }
        prijavaService.saveOrUpdatePrijava(prijava);
    }

    @DeleteMapping("/{id}")
    public void deletePrijava(@PathVariable int id) {
        prijavaService.deletePrijava(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Prijava> getPrijaveByStudentId(@PathVariable Long studentId) {
        return prijavaService.getPrijaveByStudentId(studentId);
    }
}