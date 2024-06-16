package com.studentsystem.studentsystem.service.impl;

import com.studentsystem.studentsystem.entity.Ocena;
import com.studentsystem.studentsystem.repository.OcenaRepository;
import com.studentsystem.studentsystem.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcenaServiceImpl implements OcenaService {

    @Autowired
    private OcenaRepository ocenaRepository;

    @Override
    public List<Ocena> getAllOcene() {
        return ocenaRepository.findAll();
    }

    @Override
    public Ocena getOcenaById(int id) {
        return ocenaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrUpdateOcena(Ocena ocena) {
        ocenaRepository.save(ocena);
    }

    @Override
    public void deleteOcena(int id) {
        ocenaRepository.deleteById(id);
    }

    @Override
    public boolean existsByStudentAndKurs(int studentId, int kursId) {
        return ocenaRepository.existsByStudentStudentIdAndKursKursId(studentId, kursId);
    }
}
