package com.studentsystem.studentsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "kursevi")
@Getter
@Setter
public class Kurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kursId;

    private String nazivKursa;
    private String opis;
    private int espb;
}
