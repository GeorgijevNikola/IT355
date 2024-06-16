package com.studentsystem.studentsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "korisnici")
@Getter
@Setter
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long korisnikId;

    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String email;
    private String role; // zadrži kao varchar u bazi
}
