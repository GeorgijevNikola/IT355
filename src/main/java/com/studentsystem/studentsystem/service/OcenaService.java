package com.studentsystem.studentsystem.service;

import com.studentsystem.studentsystem.entity.Ocena;

import java.util.List;

public interface OcenaService {
    List<Ocena> getAllOcene();
    Ocena getOcenaById(int id);
    void saveOrUpdateOcena(Ocena ocena);
    void deleteOcena(int id);
    boolean existsByStudentAndKurs(int studentId, int kursId);
}
