package com.studentsystem.studentsystem.service;

import com.studentsystem.studentsystem.entity.Nastavnik;

import java.util.List;

public interface NastavnikService {
    List<Nastavnik> getAllNastavnici();
    Nastavnik addNastavnik(Nastavnik nastavnik);
    Nastavnik getNastavnikById(Long id);
    Nastavnik updateNastavnik(Long id, Nastavnik nastavnik);
    void deleteNastavnik(Long id);
}
