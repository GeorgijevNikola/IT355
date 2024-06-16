package com.studentsystem.studentsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "studenti")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String ime;
    private String prezime;
    private String email;
    private String brojIndeksa;
}
