package com.studentsystem.studentsystem.controller;

import com.studentsystem.studentsystem.entity.Kurs;
import com.studentsystem.studentsystem.service.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kursevi")
public class KursController {

    @Autowired
    private KursService kursService;

    @GetMapping
    public List<Kurs> getAllKursevi() {
        return kursService.getAllKursevi();
    }

    @GetMapping("/{id}")
    public Kurs getKursById(@PathVariable Long id) {
        return kursService.getKursById(id);
    }

    @PostMapping
    public Kurs addKurs(@RequestBody Kurs kurs) {
        return kursService.addKurs(kurs);
    }

    @PutMapping("/{id}")
    public Kurs updateKurs(@PathVariable Long id, @RequestBody Kurs kurs) {
        return kursService.updateKurs(id, kurs);
    }

    @DeleteMapping("/{id}")
    public void deleteKurs(@PathVariable Long id) {
        kursService.deleteKurs(id);
    }
}
