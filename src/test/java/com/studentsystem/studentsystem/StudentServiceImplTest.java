package com.studentsystem.studentsystem;

import com.studentsystem.studentsystem.entity.Student;
import com.studentsystem.studentsystem.repository.StudentRepository;
import com.studentsystem.studentsystem.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStudents() {
        Student student1 = new Student();
        student1.setStudentId(1L);
        student1.setIme("Nikola");
        student1.setPrezime("Georgijev");
        student1.setEmail("nikola.georgijev.5201@metropolitan.ac.rs");
        student1.setBrojIndeksa("5201");

        Student student2 = new Student();
        student2.setStudentId(2L);
        student2.setIme("Nikola");
        student2.setPrezime("Randjelovic");
        student2.setEmail("nikola.randjelovic.5033@metropolitan.ac.rs");
        student2.setBrojIndeksa("5033");

        when(studentRepository.findAll()).thenReturn(List.of(student1, student2));

        List<Student> students = studentService.getAllStudents();
        assertEquals(2, students.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testAddStudent() {
        Student student = new Student();
        student.setStudentId(3L);
        student.setIme("Marko");
        student.setPrezime("Markovic");
        student.setEmail("marko.markovic@example.com");
        student.setBrojIndeksa("12345");

        when(studentRepository.existsByBrojIndeksa("12345")).thenReturn(false);
        when(studentRepository.existsByEmail("marko.markovic@example.com")).thenReturn(false);
        when(studentRepository.save(student)).thenReturn(student);

        Student addedStudent = studentService.addStudent(student);
        assertNotNull(addedStudent);
        assertEquals("Marko", addedStudent.getIme());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testAddStudentWithExistingBrojIndeksa() {
        Student student = new Student();
        student.setStudentId(3L);
        student.setIme("Marko");
        student.setPrezime("Markovic");
        student.setEmail("marko.markovic@example.com");
        student.setBrojIndeksa("5201");

        when(studentRepository.existsByBrojIndeksa("5201")).thenReturn(true);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            studentService.addStudent(student);
        });

        assertEquals("Student sa istim brojem indeksa već postoji.", exception.getMessage());
        verify(studentRepository, never()).save(any(Student.class));
    }

    @Test
    void testAddStudentWithExistingEmail() {
        Student student = new Student();
        student.setStudentId(3L);
        student.setIme("Marko");
        student.setPrezime("Markovic");
        student.setEmail("nikola.georgijev.5201@metropolitan.ac.rs");
        student.setBrojIndeksa("12345");

        when(studentRepository.existsByEmail("nikola.georgijev.5201@metropolitan.ac.rs")).thenReturn(true);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            studentService.addStudent(student);
        });

        assertEquals("Student sa istim email-om već postoji.", exception.getMessage());
        verify(studentRepository, never()).save(any(Student.class));
    }

    @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setStudentId(1L);
        student.setIme("Nikola");
        student.setPrezime("Georgijev");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.getStudentById(1L);
        assertNotNull(foundStudent);
        assertEquals("Nikola", foundStudent.getIme());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetStudentByIdNotFound() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            studentService.getStudentById(1L);
        });

        assertEquals("Student nije pronađen", exception.getMessage());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateStudent() {
        Student existingStudent = new Student();
        existingStudent.setStudentId(1L);
        existingStudent.setIme("Nikola");
        existingStudent.setPrezime("Georgijev");

        Student updatedStudent = new Student();
        updatedStudent.setIme("Nikola");
        updatedStudent.setPrezime("Georgijev");
        updatedStudent.setEmail("nikola.georgijev.5201@metropolitan.ac.rs");
        updatedStudent.setBrojIndeksa("5201");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(existingStudent));
        when(studentRepository.save(existingStudent)).thenReturn(existingStudent);

        Student result = studentService.updateStudent(1L, updatedStudent);
        assertNotNull(result);
        assertEquals("Nikola", result.getIme());
        assertEquals("Georgijev", result.getPrezime());
        assertEquals("nikola.georgijev.5201@metropolitan.ac.rs", result.getEmail());
        assertEquals("5201", result.getBrojIndeksa());
        verify(studentRepository, times(1)).save(existingStudent);
    }

    @Test
    void testDeleteStudent() {
        long studentId = 1L;
        studentService.deleteStudent(studentId);
        verify(studentRepository, times(1)).deleteById(studentId);
    }
}

