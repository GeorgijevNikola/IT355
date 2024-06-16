package com.studentsystem.studentsystem.repository;

import com.studentsystem.studentsystem.entity.Prijava;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrijavaRepository extends JpaRepository<Prijava, Integer> {
    boolean existsByStudentStudentIdAndKursKursId(Long studentId, Long kursId);
    List<Prijava> findByStudentStudentId(Long studentId);
}
