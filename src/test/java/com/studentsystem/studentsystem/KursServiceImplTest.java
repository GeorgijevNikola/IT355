package com.studentsystem.studentsystem;

import com.studentsystem.studentsystem.entity.Kurs;
import com.studentsystem.studentsystem.repository.KursRepository;
import com.studentsystem.studentsystem.service.impl.KursServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KursServiceImplTest {

    @Mock
    private KursRepository kursRepository;

    @InjectMocks
    private KursServiceImpl kursService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllKursevi() {
        Kurs kurs1 = new Kurs();
        kurs1.setKursId(1);
        kurs1.setNazivKursa("Programiranje");
        kurs1.setOpis("Osnove programiranja");
        kurs1.setEspb(6);

        Kurs kurs2 = new Kurs();
        kurs2.setKursId(2);
        kurs2.setNazivKursa("Baze podataka");
        kurs2.setOpis("Uvod u baze podataka");
        kurs2.setEspb(6);

        List<Kurs> kursList = Arrays.asList(kurs1, kurs2);

        when(kursRepository.findAll()).thenReturn(kursList);

        List<Kurs> result = kursService.getAllKursevi();

        assertEquals(2, result.size());
        assertEquals("Programiranje", result.get(0).getNazivKursa());
        assertEquals("Baze podataka", result.get(1).getNazivKursa());
    }

    @Test
    void testAddKurs() {
        Kurs kurs = new Kurs();
        kurs.setKursId(1);
        kurs.setNazivKursa("Programiranje");
        kurs.setOpis("Osnove programiranja");
        kurs.setEspb(6);

        when(kursRepository.save(kurs)).thenReturn(kurs);

        Kurs result = kursService.addKurs(kurs);

        assertNotNull(result);
        assertEquals("Programiranje", result.getNazivKursa());
    }

    @Test
    void testGetKursById() {
        Kurs kurs = new Kurs();
        kurs.setKursId(1);
        kurs.setNazivKursa("Programiranje");
        kurs.setOpis("Osnove programiranja");
        kurs.setEspb(6);

        when(kursRepository.findById(1)).thenReturn(Optional.of(kurs));

        Kurs result = kursService.getKursById(1L);

        assertNotNull(result);
        assertEquals("Programiranje", result.getNazivKursa());
    }

    @Test
    void testUpdateKurs() {
        Kurs kurs = new Kurs();
        kurs.setKursId(1);
        kurs.setNazivKursa("Programiranje");
        kurs.setOpis("Osnove programiranja");
        kurs.setEspb(6);

        Kurs updatedKurs = new Kurs();
        updatedKurs.setNazivKursa("Napredno programiranje");
        updatedKurs.setOpis("Napredne tehnike programiranja");
        updatedKurs.setEspb(8);

        when(kursRepository.findById(1)).thenReturn(Optional.of(kurs));
        when(kursRepository.save(any(Kurs.class))).thenReturn(updatedKurs);

        Kurs result = kursService.updateKurs(1L, updatedKurs);

        assertNotNull(result);
        assertEquals("Napredno programiranje", result.getNazivKursa());
    }

    @Test
    void testDeleteKurs() {
        kursService.deleteKurs(1L);
        verify(kursRepository, times(1)).deleteById(1);
    }
}