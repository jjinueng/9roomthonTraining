package com.goorm.tricountsonic.model;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/*
* - 정산은 여러개의 지출을 가지고 있습니다. (1:N)

    ex) 강릉 여행 정산 (settlement) 은 다음의 지출(expense)을 가지고 있습니다.

    - 기차표  예매(지출 이름)
        - 유저 1 (지출한 사람)
        - 80,000 원 (지출 금액)
        - 2023-08-01 (지출 날짜)
    - 숙소 값 (지출 이름)
        - 유저 2 (지출한 사람)
        - 200,000 원 (지출 금액)
        - 2023-08-02 (지출 날짜)
    - 첫날 저녁 (지출 이름)
        - 유저 1 (지출한 사람)
        - 50,000 원 (지출 금액)
- 지출에서 지출 금액의 단위는 원화를 기준으로 합니다.
* */

public class Settlement {
    private Long id;
    private String name;
    private List<Member> participants = Collections.emptyList();//특정 정산에 참여한 유저들만 정산 내역을 열람할 수 있다.
}


/*
*
* - 정산 결과 (balance)
    - 하나의 정산은 하나의 정산 결과를 가지고 있습니다. (1:1 대응)
    - 정산 결과에서는 정산에 참여(join)한 유저끼리 송금을 얼만큼 해줘야 하는지를 보여줘야 합니다
* */