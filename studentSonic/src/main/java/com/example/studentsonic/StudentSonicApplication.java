package com.example.studentsonic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentSonicApplication {

  public static void main(String[] args) {
    SpringApplication.run(StudentSonicApplication.class, args);
  }

}
//    Status.code: http status 가 아닌 서버에서 정의하는 code값이 담겨져 있어야 합니다.(정상응답에서는 항상 200)
//
//		Status.message: 정상응답시에는 “OK”, 에러 응답에서는 에러에대한 상세한 이유를 담아줍니다.


//
//		Metadata.resultCount: 정상 응답시에 나타나는 값입니다. results list 의 count 를 담아줍니다.



//
//		Results: 정상응답시에 나타나는 값입니다. 항상 list 형태로, 실제 응답으로 내주고싶은 정보가 표시됩니다.



//
//		Data: 에러 응답시에 나타나는 값으로, 에러 응답시에 frontend 에서 사용자에게 어떤 이유로 요청이 거부되었는지 메세지를 만들기 쉽게 필요한 데이터를 넣어줍니다.  ****
//


//		위의 응답(에러) 예시를 만족하는 응답을 가진 API 를 구현합니다.


//**API 요구사항**
//
//		1. 이름과 성적을 입력받아 저장하는 api
//			- 성적의 입력은 특정 값(위 에러 응답일 경우에서는 6) 이 넘었을 경우에는 에러 응답이 나타나야 합니다.
//		{
//			"status":{
//				"code":2000,
//				"message":"OK"
//			},
//			"metadata":{
//				"resultCount": 1
//			},
//			"results":[
//				{
//					"name":"kim",
//					"grade":"1"
//				}
//			]
//		}
//