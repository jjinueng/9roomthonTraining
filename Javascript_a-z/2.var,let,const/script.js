// var

// var greeting = "hello";
// console.log(greeting);

// var greeeting = "hi";
// console.log(greeeting);

// greeeting = 'how are you?';
// console.log(greeeting);

// let

// let greeting = "hello";
// console.log(greeting);

// // let greeting = "hi"; // 중복 선언 불가, 재할당은 가능

// greeting = 'hi';
// console.log(greeting);

// const

// 중복 선언 불가, 재할당 불가

// const greeting = "hello";
// console.log(greeting);

// greeting = "hi"; // 재할당도 콘솔에서 오류가 뜸

// console.log(greeting);

//var, let, const를 선언하지 않으면 자동으로 var로 선언됨


// var 함수 레벨 스코프
// function func() {
//     if (true) {
//         var a = 'a';
//         console.log(a);
//     }
//     console.log(a);
// }
// console.log(a);
// func();


// let, const 블록 레벨 스코프
// function func() {
//     if (true) {
//         let a = 'a';
//         console.log(a);
//     }
//     console.log(a);
// }
// func();

// console.log(greeting);
// var greeting = 'hello';

func();

function func() { 
    console.log('hoistiong test'); 
}

// let, const는 호이스팅이 되지만 초기화가 되지 않음
// 이러한 특징을 TDZ(Temporal Dead Zone)이라고 함

// 결론 : var는 사용하지 않는 것이 좋음
//        let, const는 호이스팅이 되지만 초기화가 되지 않음
//        재할당이 필요한 경우에는 let을 사용
//        재할당이 필요하지 않은 경우에는 const를 사용