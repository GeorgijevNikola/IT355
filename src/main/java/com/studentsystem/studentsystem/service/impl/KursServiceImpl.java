package com.studentsystem.studentsystem.service.impl;

import com.studentsystem.studentsystem.entity.Kurs;
import com.studentsystem.studentsystem.repository.KursRepository;
import com.studentsystem.studentsystem.service.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KursServiceImpl implements KursService {

    @Autowired
    private KursRepository kursRepository;

    @Override
    public List<Kurs> getAllKursevi() {
        return kursRepository.findAll();
    }

    @Override
    public Kurs addKurs(Kurs kurs) {
        return kursRepository.save(kurs);
    }

    @Override
    public Kurs getKursById(Long id) {
        return kursRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Kurs not found"));
    }

    @Override
    public Kurs updateKurs(Long id, Kurs kurs) {
        Kurs existingKurs = kursRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("Kurs not found"));
        existingKurs.setNazivKursa(kurs.getNazivKursa());
        existingKurs.setOpis(kurs.getOpis());
        existingKurs.setEspb(kurs.getEspb());
        return kursRepository.save(existingKurs);
    }

    @Override
    public void deleteKurs(Long id) {
        kursRepository.deleteById(Math.toIntExact(id));
    }
}
