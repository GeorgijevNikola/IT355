package com.studentsystem.studentsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ocene")
@Getter
@Setter
public class Ocena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ocenaId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "kurs_id", nullable = false)
    private Kurs kurs;

    private int ocena;
    private LocalDate datum;
}
