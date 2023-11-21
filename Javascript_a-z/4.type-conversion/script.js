let val;

// Number to string
val = String(111);

console.log(val);
console.log(typeof val);
console.log(val.length);

// Boolean to string
val = String(false);

console.log(val);
console.log(typeof val);
console.log(val.length);

// Date to string
val = String(new Date());

console.log(val);
console.log(typeof val);
console.log(val.length);

// Array to string
val = String([1, 2, 3, 4, 5]);

console.log(val);
console.log(typeof val);
console.log(val.length);

// toString()
val = (5).toString();

console.log(val);
console.log(typeof val);
console.log(val.length);

// String to number
val = Number("1");

console.log(val);
console.log(typeof val);
console.log(val.length); // undefined

// Boolean to number
val = Number(true);

console.log(val);
console.log(typeof val);
console.log(val.length); // undefined

// null to number
val = Number(null);

console.log(val);
console.log(typeof val);
console.log(val.length); // undefined

// array to number
val = Number([1, 2, 3]);

console.log(val); // NaN
console.log(typeof val);
console.log(val.length); // undefined

val = parseInt("111.40"); // 소수점 이하 버림

console.log(val);
console.log(typeof val);
console.log(val.length);

val = parseFloat("111.40"); // 소수점 살림

console.log(val);
console.log(typeof val);
console.log(val.length);

// 자동으로 타입 변환
const val1 = 2;
const val2 = 3;
const sum = val1 + val2;

console.log(sum);
console.log(typeof sum);

const val3 = String(2);
const val4 = 3; // 자동으로 타입 변환, 3 -> "3"
const sum2 = val3 + val4;

console.log(sum2);
console.log(typeof sum2);