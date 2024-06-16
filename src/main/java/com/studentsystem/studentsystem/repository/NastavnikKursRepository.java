package com.studentsystem.studentsystem.repository;

import com.studentsystem.studentsystem.entity.NastavnikKurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NastavnikKursRepository extends JpaRepository<NastavnikKurs, Long> {
    boolean existsByNastavnikNastavnikIdAndKursKursId(Long nastavnikId, Long kursId);
}
