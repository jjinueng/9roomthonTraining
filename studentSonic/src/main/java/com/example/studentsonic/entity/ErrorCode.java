package com.example.studentsonic.entity;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

  OK(2000, "OK", HttpStatus.OK), BAD_REQUEST(5000, "BAD REQUEST", HttpStatus.BAD_REQUEST);
  //INTERNAL_SERVER_ERROR
  private final int code;
  private final String message;

  private final HttpStatus httpStatus;

  ErrorCode(int code, String message, HttpStatus httpStatus) {
    this.code = code;
    this.message = message;
    this.httpStatus = httpStatus;
  }


}
