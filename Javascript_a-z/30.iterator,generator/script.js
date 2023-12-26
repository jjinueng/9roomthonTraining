function makeIterator(numbers) {
    let nextIndex = 0;
    return {
        next: function () {
            return nextIndex < numbers.length ?
                { value: numbers[nextIndex++], done: false } :
                { value: undefined, done: true };
        }
    }
}


// 숫자 배열 생성
const numbersArray = [1, 2, 3];

// 이터레이터 생성
// const numbersIterator = makeIterator(numbersArray);
// [Symbol.iterator]()를 이용하면 반복 가능한 객체를 만들 수 있다.
const numbersIterator = numbersArray[Symbol.iterator]();

console.log(numbersIterator.next()); // {value: 1, done: false}
console.log(numbersIterator.next());


function* sayNumbers() {
    yield 1;
    yield 2;
    yield 3;
}

const number = sayNumbers();

console.log(number.next());
console.log(number.next());

function* generatorFunction() {
    yield 1;
}

const generator = generatorFunction();
// generator = generator[Symbol.iterator]();
console.log(generator.next());


function* createIds(){ // lazy evaluation
    let index = 1;
    while(true){
        yield index++;
    }
}

const gen = createIds();
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.return(10));


function* generatorFunction2() {
    yield* [1, 2, 3];
    
}