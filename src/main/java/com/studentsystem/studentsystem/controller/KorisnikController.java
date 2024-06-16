package com.studentsystem.studentsystem.controller;

import com.studentsystem.studentsystem.entity.Korisnik;
import com.studentsystem.studentsystem.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping
    public List<Korisnik> getAllKorisnici() {
        return korisnikService.getAllKorisnici();
    }

    @GetMapping("/{id}")
    public Korisnik getKorisnikById(@PathVariable long id) {
        return korisnikService.getKorisnikById(id);
    }

    @GetMapping("/username/{username}")
    public Korisnik getKorisnikByUsername(@PathVariable String username) {
        return korisnikService.getKorisnikByUsername(username);
    }

    @PostMapping
    public void saveOrUpdateKorisnik(@RequestBody Korisnik korisnik) {
        korisnikService.saveOrUpdateKorisnik(korisnik);
    }

    @DeleteMapping("/{id}")
    public void deleteKorisnik(@PathVariable long id) {
        korisnikService.deleteKorisnik(id);
    }

    @GetMapping("/userinfo")
    public ResponseEntity<?> getUserInfo(Principal principal) {
        Korisnik korisnik = korisnikService.getKorisnikByUsername(principal.getName());
        if (korisnik != null) {
            return ResponseEntity.ok(Map.of("role", korisnik.getRole(), "username", korisnik.getUsername()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
