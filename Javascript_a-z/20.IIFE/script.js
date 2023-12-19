// (function () {
//     var aName = 'Barry';
// })();
// // IIFE 내부에서 정의된 변수는 외부에서 접근할 수 없다.
// console.log(aName)

// var result = (function () {
//     var name = 'Barry';
//     return name;
// })();

// console.log(result); // 함수가 실행되고 반환된 값이 출력된다. function() { var name = 'Barry'; return name; }이 출력되는 것이 아니다.


// const score = () => {
//     let count = 0;
//     return {
//         current: () => { return count },
//         increment: () => { count++ },
//         reset: () => { count = 0 }
//     }
// }

// console.log(typeof score)
// console.log(score)
// console.log(score().current())
// score().increment()
// console.log(score().current())

const score = (() => {
    let count = 0;
    return {
        current: () => { return count },
        increment: () => { count++ },
        reset: () => { count = 0 }
    }
})()

console.log(typeof score)
console.log(score)
console.log(score.current())
score.increment()
score.increment()
score.increment()
score.increment()
console.log(score.current())
score.reset()
console.log(score.current())

// console.log(score().current())
// score().increment()
// console.log(score().current())

const increment= (() => {
    let counter = 0;
    console.log(counter)
    const number = (num) => 
        console.log(`it is ${num} number`)
    return () => {
        counter++
        number(counter)
    }
})();

console.log(increment)
increment()
increment()