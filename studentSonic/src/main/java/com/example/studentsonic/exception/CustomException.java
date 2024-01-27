package com.example.studentsonic.exception;

import java.util.AbstractMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.example.studentsonic.entity.ErrorCode;
import lombok.Getter;

public class CustomException extends RuntimeException {
  @Getter
  private final ErrorCode errorCode;
  private String message;
  //inputRestriction 이라는 특정 데이터를 나타내는 값을 가지고 있으니까
  //String Object
  //			"data":{
  //				    "inputRestriction": {
  //					    "maxGrade":"6"
  //				    }
  //			}
  @Getter
  private Map.Entry<String, Object> data;

  @Override
  public String getMessage() {
    if (StringUtils.hasLength(this.message)) {
      return this.message;
    }
    return errorCode.getMessage();
  }

  public CustomException(ErrorCode errorCode, String message, Object data) {
    this.errorCode = errorCode;
    this.message = message;

    // 하위과제 null 처리
    if (data != null) {
      this.data = new AbstractMap.SimpleEntry<>(data.getClass().getSimpleName(), data);
    } else {
      this.data = null;
    }
  }
}
