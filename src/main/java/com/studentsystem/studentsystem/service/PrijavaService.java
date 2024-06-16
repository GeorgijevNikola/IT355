package com.studentsystem.studentsystem.service;

import com.studentsystem.studentsystem.entity.Prijava;

import java.util.List;

public interface PrijavaService {
    List<Prijava> getAllPrijave();
    Prijava getPrijavaById(int id);
    void saveOrUpdatePrijava(Prijava prijava);
    void deletePrijava(int id);
    boolean existsByStudentAndKurs(Long studentId, Long kursId);
    List<Prijava> getPrijaveByStudentId(Long studentId);
}
