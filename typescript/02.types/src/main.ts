//Boolean
let boolean: boolean;
let falseBoolean: boolean = false;

//Number
let number: number;
let integer: number = 6;
let float: number = 6.66;

//String
let string: string;
let firstName: string = "Doe";

//Array
//한가지 타입만 가지는 배열
let names1: string[] = ["John", "Jane", "Doe"];
let names2: Array<string> = ["John", "Jane", "Doe"];

//여러가지 타입을 가지는 배열(유니언 타입)
let names3: (string | number)[] = ["John", "Jane", "Doe", 1];
let names4: Array<string | number> = ["John", "Jane", "Doe", 1];

//여러 타입을 단언 X (any)
let someArray: any[] = ["John", 1, false, {}];

//interface, type

//읽기 전용 배열 생성 (readonly, ReadonlyArray)
let stringArray: readonly string[] = ['A', 'B', 'C'];
let numberArray: ReadonlyArray<number> = [1, 2, 3];

// stringArray.push("C");
// numberArray1[0] = 3;

//Tuple
let tuple: [string, number];
tuple = ["hello", 10];
// tuple = ["hello", 10, 20];
// tuple = [10, "hello"];

let users: [number, string][]
users = [
    [1, "John"],
    [2, "Jane"],
    [3, "Doe"],
];

let tuple2: [string, number];
tuple2 = ["hello", 10];
tuple2.push(2);
console.log(tuple2)

// any
let any: any = 'abc';
any = 123;
any = true;

// umknown
let unknown: unknown = 'abc';
let string1: string = unknown as string;

let obj: object = {};
let arr: object = [];
let nul: object = null;
let date: object = new Date();

const obj1: {id:number, title: string} = {id: 1, title: 'hello'};

// union
let union: string | number;
union = 'abc';
union = 123;

// function
