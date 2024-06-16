package com.studentsystem.studentsystem.service;

import com.studentsystem.studentsystem.entity.Kurs;

import java.util.List;

public interface KursService {
    List<Kurs> getAllKursevi();
    Kurs addKurs(Kurs kurs);
    Kurs getKursById(Long id);
    Kurs updateKurs(Long id, Kurs kurs);
    void deleteKurs(Long id);
}
