function outerFunction(outerVariable) {
    return function innerFunction(innerVariable) {
        console.log('Outer Variable: ' + outerVariable);
        console.log('Inner Variable: ' + innerVariable);
    }
}

const newFunction = outerFunction('outside');
newFunction('inside'); // innerFunction은 outerFunction의 변수에 접근할 수 있음

console.log(newFunction);

// 다른 함수 내부에 정의된 함수가 있는 경우 외부 함수가 실행 완료 후
// 해당 변수가 함수 외부에서 더이상 액세스 할 수 없어도
// 내부 함수는 외부 함수의 변수 및 범위에 접근할 수 있음


// 간단한 예시
let a = 'a';

function functionA() {
    let b = 'b';
    functionB();
    console.log(a, b);
}

functionA();

function functionB() {
    let c = 'c';
    console.log(a, b, c);
}


// b는 functionA의 지역 변수이므로 functionB에서는 액세스할 수 없음
// 이를 해결하려면 functionB()를 functionA() 내부에 정의해야 함