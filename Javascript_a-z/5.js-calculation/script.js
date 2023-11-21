const num1 = 20;
const num2 = 10;

let val;

val = num1 + num2;
console.log(val);

val = num1 * num2;
console.log(val);

val = num1 - num2;
console.log(val);

val = num1 / num2;
console.log(val);

val = num1 % num2;
console.log(val);

// Math Object
val = Math.E;
console.log(val);

val = Math.PI;
console.log(val);

val = Math.round(2.4); // 반올림
console.log(val);

val = Math.ceil(2.4); // 올림
console.log(val);

val = Math.floor(2.8); // 내림
console.log(val);

val = Math.abs(-2) // 절대값
console.log(val);

val = Math.min(2,3,4,5,6,7,8,-1) // 최소값
console.log(val);

val = Math.max(2,3,4,5,6,7,8,-1) // 최대값
console.log(val);

val = Math.random(); // 랜덤값 0~1
console.log(val);

// 1~20 사이의 랜덤값
val = Math.floor(Math.random() * 20 + 1);
console.log(val);
// floor 대신에 ceil을 쓰면?
val = Math.ceil(Math.random() * 20);
console.log(val);
// round를 쓰면?
val = Math.round(Math.random() * 20);
console.log(val);

// 3가지 모두 1~20 사이의 랜덤값을 뽑는다.
// 하지만 round는 0을 포함하여 랜덤값을 뽑는다.
// floor를 사용하는 것이 각 숫자가 생성될 확률이 거의 동일하다.