package com.studentsystem.studentsystem.service;

import com.studentsystem.studentsystem.entity.Korisnik;

import java.util.List;

public interface KorisnikService {
    List<Korisnik> getAllKorisnici();
    Korisnik getKorisnikById(long id);
    Korisnik getKorisnikByUsername(String username);
    void saveOrUpdateKorisnik(Korisnik korisnik);
    void deleteKorisnik(long id);
}
