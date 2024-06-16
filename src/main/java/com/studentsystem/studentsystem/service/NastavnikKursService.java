package com.studentsystem.studentsystem.service;

import com.studentsystem.studentsystem.entity.NastavnikKurs;

import java.util.List;

public interface NastavnikKursService {
    List<NastavnikKurs> getAllNastavnikKurs();
    NastavnikKurs getNastavnikKursById(Long id);
    void saveOrUpdateNastavnikKurs(NastavnikKurs nastavnikKurs);
    void deleteNastavnikKurs(Long id);
    boolean existsByNastavnikAndKurs(Long nastavnikId, Long kursId);
}
