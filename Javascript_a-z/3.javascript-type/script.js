let foo = 42;
console.log(typeof foo); // number

foo = 'bar';
console.log(typeof foo); // string

foo = true;
console.log(typeof foo); // boolean

//원시 타입
// 문자열 String
const name = "han";
// 숫자 Number
const age = 30;
// 불리언 Boolean
const hasJob = true;
// null
const car = null;
// undefined
let anything;
// Symbol
const sym = Symbol();

// 참조 타입 - 객체
// 배열 Array
const hobbies = ['walking', 'books']
// 객체 Object
const address = {
    province: '경기도',
    city: '성남시'
}

console.log(typeof hobbies); // object -> 배열도 결국에는 object
console.log(typeof address); // object

// 배열인지 객체인지 확인하는 방법
console.log(Array.isArray(hobbies)); // true
console.log(Array.isArray(address)); // false