const sym1 = Symbol();
const sym2 = Symbol();

console.log(sym1 === sym2); // false

const sym3 = Symbol('cat');
console.log(sym3.description); // cat

// 언제 사용할까?

let carA ={
    id: 1,
    name: 'morning',
    brand : 'kia',
    price: 1000

};

const idSym = Symbol('id');
carA[idSym] = 300; // idSym이라는 심볼을 만들어서 carA에 추가, idSym은 고유한 값이므로 중복되지 않는다.

console.log(carA) 


for (let key in carA){
    console.log(key, carA[key]);
} // symbol은 for in문에서 출력되지 않는다.

console.log(Object.keys(carA)); // symbol은 keys에 포함되지 않는다.

console.log(Object.getOwnPropertyNames(carA)); // symbol은 포함되지 않는다.

console.log(JSON.stringify(carA)); // symbol은 포함되지 않는다.

console.log(Object.getOwnPropertySymbols(carA)); // symbol만 출력된다.

const Sym1 = Symbol.for('sym1');
const Sym2 = Symbol.for('sym1');

console.log(Sym1 === Sym2); // true

console.log(Symbol.keyFor(Sym1)); // sym1
console.log(Symbol.keyFor(Sym2)); // sym1


// 사용 예시

const RED = Symbol('red');
const ORANGE = Symbol('orange');
const YELLOW = Symbol('yellow');
const BLUE = Symbol('blue');
const dog = 'blue';

function getImportantLevel(color){
    switch(color){
        case RED:
            return 'very important';
        case ORANGE:
            return 'important';
        case YELLOW:
            return 'little important';
        case BLUE:
            return 'not important';
        default:
            console.log(`${color} not included`);
    }
}

console.log(getImportantLevel(BLUE)); // not important
console.log(getImportantLevel(dog)); // not important

const length = Symbol('length');

class Car {
    constructor(){
        this[length] = 0;
    }
    add(brand,name){
        this[brand] = name;
        this[length]++;
    }
}

let myCars = new Car();
myCars.add('kia','morning');
myCars.add('hyundai','tucson');
myCars.add('genesis','bv80');

for(const car in myCars){
    // symbol로 만든 length는 for in문에서 출력되지 않는다.
    console.log(car, myCars[car]);
}
