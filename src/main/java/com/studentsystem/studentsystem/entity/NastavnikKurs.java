package com.studentsystem.studentsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nastavnik_kurs")
@Getter
@Setter
public class NastavnikKurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nastavnik_id", referencedColumnName = "nastavnikId")
    private Nastavnik nastavnik;

    @ManyToOne
    @JoinColumn(name = "kurs_id", referencedColumnName = "kursId")
    private Kurs kurs;
}
