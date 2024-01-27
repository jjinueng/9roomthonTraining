package com.example.studentsonic.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.studentsonic.entity.Student;

@Repository
public class StudentRepository {
  Set<Student> students = new HashSet<>();

  // 1. 이름과 성적을 받아서 저장
  public void add(Student student) {
    students.add(student);
  }

  // 2. 전체 성적을 오름차순으로 정렬해서 가져오기
  public List<Student> getAll() {
    return students.stream().sorted().collect(Collectors.toList());
  }

  // 3. 특정 성적을 입력받아 해당 성적의 학생들을 조회
  public List<Student> get(int grade) {
    return students.stream()
      .filter(student -> student.getGrade() == grade)
      .collect(Collectors.toList());
  }



}
