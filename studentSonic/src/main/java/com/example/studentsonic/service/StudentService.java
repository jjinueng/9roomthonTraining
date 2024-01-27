package com.example.studentsonic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentsonic.entity.Student;
import com.example.studentsonic.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository studentRepository;
  public Student addStudent(String name, int grade) {
    Student student = new Student(name, grade);
    studentRepository.add(student);

    return student;
  }

  public List<Student> getAll() {
    return studentRepository.getAll();
  }

  public List<Student> getGradeStudent(int grade) {
    return studentRepository.get(grade);
  }
}
