package com.studentsystem.studentsystem.service.impl;

import com.studentsystem.studentsystem.entity.Nastavnik;
import com.studentsystem.studentsystem.repository.NastavnikRepository;
import com.studentsystem.studentsystem.service.NastavnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NastavnikServiceImpl implements NastavnikService {

    @Autowired
    private NastavnikRepository nastavnikRepository;

    @Override
    public List<Nastavnik> getAllNastavnici() {
        return nastavnikRepository.findAll();
    }

    @Override
    public Nastavnik addNastavnik(Nastavnik nastavnik) {
        return nastavnikRepository.save(nastavnik);
    }

    @Override
    public Nastavnik getNastavnikById(Long id) {
        return nastavnikRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Nastavnik not found"));
    }

    @Override
    public Nastavnik updateNastavnik(Long id, Nastavnik nastavnik) {
        Nastavnik existingNastavnik = nastavnikRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Nastavnik not found"));
        existingNastavnik.setIme(nastavnik.getIme());
        existingNastavnik.setPrezime(nastavnik.getPrezime());
        existingNastavnik.setEmail(nastavnik.getEmail());
        return nastavnikRepository.save(existingNastavnik);
    }

    @Override
    public void deleteNastavnik(Long id) {
        nastavnikRepository.deleteById(Math.toIntExact(id));
    }
}
