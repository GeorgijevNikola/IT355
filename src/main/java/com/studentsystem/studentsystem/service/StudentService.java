package com.studentsystem.studentsystem.service;

import com.studentsystem.studentsystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student) throws RuntimeException;;
    Student getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
