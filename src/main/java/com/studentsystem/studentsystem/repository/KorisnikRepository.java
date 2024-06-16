package com.studentsystem.studentsystem.repository;

import com.studentsystem.studentsystem.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByUsername(String username);
    Korisnik findByEmail(String email);
}
