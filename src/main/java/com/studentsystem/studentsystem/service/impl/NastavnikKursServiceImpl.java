package com.studentsystem.studentsystem.service.impl;

import com.studentsystem.studentsystem.entity.NastavnikKurs;
import com.studentsystem.studentsystem.repository.NastavnikKursRepository;
import com.studentsystem.studentsystem.service.NastavnikKursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NastavnikKursServiceImpl implements NastavnikKursService {

    @Autowired
    private NastavnikKursRepository nastavnikKursRepository;

    @Override
    public List<NastavnikKurs> getAllNastavnikKurs() {
        return nastavnikKursRepository.findAll();
    }

    @Override
    public NastavnikKurs getNastavnikKursById(Long id) {
        return nastavnikKursRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrUpdateNastavnikKurs(NastavnikKurs nastavnikKurs) {
        nastavnikKursRepository.save(nastavnikKurs);
    }

    @Override
    public void deleteNastavnikKurs(Long id) {
        nastavnikKursRepository.deleteById(id);
    }

    @Override
    public boolean existsByNastavnikAndKurs(Long nastavnikId, Long kursId) {
        return nastavnikKursRepository.existsByNastavnikNastavnikIdAndKursKursId(nastavnikId, kursId);
    }
}
