package com.studentsystem.studentsystem.repository;

import com.studentsystem.studentsystem.entity.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcenaRepository extends JpaRepository<Ocena, Integer> {
    boolean existsByStudentStudentIdAndKursKursId(int studentId, int kursId);
}
