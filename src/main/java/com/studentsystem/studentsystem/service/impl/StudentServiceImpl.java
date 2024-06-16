package com.studentsystem.studentsystem.service.impl;

import com.studentsystem.studentsystem.entity.Student;
import com.studentsystem.studentsystem.repository.StudentRepository;
import com.studentsystem.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) throws RuntimeException {
        if (studentRepository.existsByBrojIndeksa(student.getBrojIndeksa())) {
            throw new RuntimeException("Student sa istim brojem indeksa već postoji.");
        }
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Student sa istim email-om već postoji.");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student nije pronađen"));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student nije pronađen"));
        existingStudent.setIme(student.getIme());
        existingStudent.setPrezime(student.getPrezime());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBrojIndeksa(student.getBrojIndeksa());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}