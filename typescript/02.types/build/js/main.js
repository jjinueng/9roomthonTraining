//Boolean
let boolean;
let falseBoolean = false;
//Number
let number;
let integer = 6;
let float = 6.66;
//String
let string;
let firstName = "Doe";
//Array
//한가지 타입만 가지는 배열
let names1 = ["John", "Jane", "Doe"];
let names2 = ["John", "Jane", "Doe"];
//여러가지 타입을 가지는 배열(유니언 타입)
let names3 = ["John", "Jane", "Doe", 1];
let names4 = ["John", "Jane", "Doe", 1];
//여러 타입을 단언 X (any)
let someArray = ["John", 1, false, {}];
//interface, type
//읽기 전용 배열 생성 (readonly, ReadonlyArray)
let stringArray = ['A', 'B', 'C'];
let numberArray = [1, 2, 3];
// stringArray.push("C");
// numberArray1[0] = 3;
//Tuple
let tuple;
tuple = ["hello", 10];
// tuple = ["hello", 10, 20];
// tuple = [10, "hello"];
let users;
users = [
    [1, "John"],
    [2, "Jane"],
    [3, "Doe"],
];
let tuple2;
tuple2 = ["hello", 10];
tuple2.push(2);
console.log(tuple2);
// any
let any = 'abc';
any = 123;
any = true;
// umknown
let unknown = 'abc';
let string1 = unknown;
let obj = {};
let arr = [];
let nul = null;
let date = new Date();
const obj1 = { id: 1, title: 'hello' };
// union
let union;
union = 'abc';
union = 123;
// function
