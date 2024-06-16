package com.studentsystem.studentsystem.service.impl;

import com.studentsystem.studentsystem.entity.Prijava;
import com.studentsystem.studentsystem.repository.PrijavaRepository;
import com.studentsystem.studentsystem.service.PrijavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrijavaServiceImpl implements PrijavaService {

    @Autowired
    private PrijavaRepository prijavaRepository;

    @Override
    public List<Prijava> getAllPrijave() {
        return prijavaRepository.findAll();
    }

    @Override
    public Prijava getPrijavaById(int id) {
        return prijavaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrUpdatePrijava(Prijava prijava) {
        prijavaRepository.save(prijava);
    }

    @Override
    public void deletePrijava(int id) {
        prijavaRepository.deleteById(id);
    }

    @Override
    public boolean existsByStudentAndKurs(Long studentId, Long kursId) {
        return prijavaRepository.existsByStudentStudentIdAndKursKursId(studentId, kursId);
    }

    @Override
    public List<Prijava> getPrijaveByStudentId(Long studentId) {
        return prijavaRepository.findByStudentStudentId(studentId);
    }
}
