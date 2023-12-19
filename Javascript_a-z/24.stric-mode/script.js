"use strict"

function sum(a,b){
    // "use strict" 이 함수만 엄격 모드로 실행
    return a + b;
}

class Cat {

}

const obj = {};
Object.defineProperty(obj, "readOnly", {
    writable: false, value: 7
})

console.log(obj);
obj.readOnly = 25; // 할당할 수 없는데 할당하려고 하면 스트릭 모드에서는 에러가 발생한다.
console.log(obj);

let greeting = "Hello";
greating = 'hi';

console.log(greeting);
console.log(greeting, window.greating); // 스트릭 모드에서는 window.greating이 undefined

const obj2 = {
    get readOnly(){
        return 7;
    }
}

console.log(obj2.readOnly);
obj2.readOnly = 25; 
console.log(obj2.readOnly);

function add(a, a, a){
    return a + a + a; // 스트릭 모드에서는 에러가 발생한다.
}

console.log(add(1,2,3));

function sum(a, b){
    console.log(this); // 스트릭 모드에서는 this가 undefined
    return a + b; 
}
sum(1,2);
sum.bind(this)(1,2);
