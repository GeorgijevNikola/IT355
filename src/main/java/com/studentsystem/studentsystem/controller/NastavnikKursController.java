package com.studentsystem.studentsystem.controller;

import com.studentsystem.studentsystem.entity.NastavnikKurs;
import com.studentsystem.studentsystem.repository.KursRepository;
import com.studentsystem.studentsystem.repository.NastavnikRepository;
import com.studentsystem.studentsystem.service.NastavnikKursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nastavnik-kurs")
public class NastavnikKursController {

    @Autowired
    private NastavnikKursService nastavnikKursService;

    @Autowired
    private NastavnikRepository nastavnikRepository;

    @Autowired
    private KursRepository kursRepository;

    @GetMapping
    public List<NastavnikKurs> getAllNastavnikKurs() {
        return nastavnikKursService.getAllNastavnikKurs();
    }

    @GetMapping("/{id}")
    public NastavnikKurs getNastavnikKursById(@PathVariable Long id) {
        return nastavnikKursService.getNastavnikKursById(id);
    }

    @PostMapping
    public void saveOrUpdateNastavnikKurs(@RequestBody NastavnikKurs nastavnikKurs) {
        if (nastavnikKurs.getNastavnik() == null || nastavnikKurs.getKurs() == null) {
            throw new RuntimeException("Nastavnik i Kurs ne mogu biti null");
        }
        if (!nastavnikRepository.existsById(nastavnikKurs.getNastavnik().getNastavnikId())) {
            throw new RuntimeException("Nastavnik sa ID " + nastavnikKurs.getNastavnik().getNastavnikId() + " ne postoji");
        }
        if (!kursRepository.existsById(nastavnikKurs.getKurs().getKursId())) {
            throw new RuntimeException("Kurs sa ID " + nastavnikKurs.getKurs().getKursId() + " ne postoji");
        }
        if (nastavnikKursService.existsByNastavnikAndKurs((long) nastavnikKurs.getNastavnik().getNastavnikId(), (long) nastavnikKurs.getKurs().getKursId())) {
            throw new RuntimeException("Nastavnik je već prijavljen za ovaj kurs");
        }
        nastavnikKursService.saveOrUpdateNastavnikKurs(nastavnikKurs);
    }

    @DeleteMapping("/{id}")
    public void deleteNastavnikKurs(@PathVariable Long id) {
        nastavnikKursService.deleteNastavnikKurs(id);
    }
}
