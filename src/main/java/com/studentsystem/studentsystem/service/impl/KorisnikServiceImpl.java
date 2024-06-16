package com.studentsystem.studentsystem.service.impl;

import com.studentsystem.studentsystem.entity.Korisnik;
import com.studentsystem.studentsystem.repository.KorisnikRepository;
import com.studentsystem.studentsystem.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public List<Korisnik> getAllKorisnici() {
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik getKorisnikById(long id) {
        return korisnikRepository.findById(id).orElse(null);
    }

    @Override
    public Korisnik getKorisnikByUsername(String username) {
        return korisnikRepository.findByUsername(username);
    }

    @Override
    public void saveOrUpdateKorisnik(Korisnik korisnik) {
        korisnikRepository.save(korisnik);
    }

    @Override
    public void deleteKorisnik(long id) {
        korisnikRepository.deleteById(id);
    }
}
