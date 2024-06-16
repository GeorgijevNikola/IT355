package com.studentsystem.studentsystem.controller;

import com.studentsystem.studentsystem.entity.Nastavnik;
import com.studentsystem.studentsystem.service.NastavnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nastavnici")
public class NastavnikController {

    @Autowired
    private NastavnikService nastavnikService;

    @GetMapping
    public List<Nastavnik> getAllNastavnici() {
        return nastavnikService.getAllNastavnici();
    }

    @GetMapping("/{id}")
    public Nastavnik getNastavnikById(@PathVariable Long id) {
        return nastavnikService.getNastavnikById(id);
    }

    @PostMapping
    public Nastavnik addNastavnik(@RequestBody Nastavnik nastavnik) {
        return nastavnikService.addNastavnik(nastavnik);
    }

    @PutMapping("/{id}")
    public Nastavnik updateNastavnik(@PathVariable Long id, @RequestBody Nastavnik nastavnik) {
        return nastavnikService.updateNastavnik(id, nastavnik);
    }

    @DeleteMapping("/{id}")
    public void deleteNastavnik(@PathVariable Long id) {
        nastavnikService.deleteNastavnik(id);
    }
}
