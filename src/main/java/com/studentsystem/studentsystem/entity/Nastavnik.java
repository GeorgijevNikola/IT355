package com.studentsystem.studentsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "nastavnici")
@Getter
@Setter
public class Nastavnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nastavnikId;

    private String ime;
    private String prezime;
    private String email;
}
