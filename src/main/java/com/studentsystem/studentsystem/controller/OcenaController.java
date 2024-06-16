package com.studentsystem.studentsystem.controller;

import com.studentsystem.studentsystem.entity.Ocena;
import com.studentsystem.studentsystem.repository.KursRepository;
import com.studentsystem.studentsystem.repository.OcenaRepository;
import com.studentsystem.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocene")
public class OcenaController {

    @Autowired
    private OcenaRepository ocenaRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private KursRepository kursRepository;

    @GetMapping
    public List<Ocena> getAllOcene() {
        return ocenaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ocena getOcenaById(@PathVariable int id) {
        return ocenaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void saveOrUpdateOcena(@RequestBody Ocena ocena) {
        if (ocena.getStudent() == null || ocena.getKurs() == null) {
            throw new RuntimeException("Student i Kurs ne mogu biti null");
        }
        if (!studentRepository.existsById(ocena.getStudent().getStudentId())) {
            throw new RuntimeException("Student sa ID " + ocena.getStudent().getStudentId() + " ne postoji");
        }
        if (!kursRepository.existsById(ocena.getKurs().getKursId())) {
            throw new RuntimeException("Kurs sa ID " + ocena.getKurs().getKursId() + " ne postoji");
        }
        if (ocenaRepository.existsByStudentStudentIdAndKursKursId(Math.toIntExact(ocena.getStudent().getStudentId()), ocena.getKurs().getKursId())) {
            throw new RuntimeException("Ocena za ovog studenta na ovom kursu već postoji");
        }
        ocenaRepository.save(ocena);
    }

    @DeleteMapping("/{id}")
    public void deleteOcena(@PathVariable int id) {
        ocenaRepository.deleteById(id);
    }
}
