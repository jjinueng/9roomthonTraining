package com.example.studentsonic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {
  private String name;
  private int grade;

  @Override
  public int compareTo(Student o) {
    return this.grade - o.grade;
  }
}
