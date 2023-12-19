const sum = (x, y) => x + y;

const curriedSum = x => y => x + y;

console.log(sum(10, 20));

console.log(curriedSum(10));
console.log(curriedSum(10)(20));


const makeFood = (ingredient1) => {
    return (ingredient2) => {
        return (ingredient3) => {
            return `${ingredient1} ${ingredient2} ${ingredient3}`;
        }
    }
}

const hamburger = makeFood('bread')('ham')('tomato');
console.log(hamburger);

const cleanerMakeFood = ingredient1 => ingredient2 => ingredient3 => `${ingredient1} ${ingredient2} ${ingredient3}`;
const newHamburger = cleanerMakeFood('bread')('ham')('tomato');
console.log(newHamburger);

function log(date, importance, message) {
    console.log(`[${date.getHours()}:${date.getMinutes()}] [${importance}] ${message}`);
}

log(new Date(), 'DEBUG', 'some debug');

// curring function
function curry(f) {
    return function (a) {
        return function (b) {
            return function (c) {
                return f(a, b, c);

            }
        }
    }
}

const curriedLog = curry(log);
curriedLog(new Date())('DEBUG')('some debug');

function curry2(f){
    return function curried(...args){
        if(args.length >= f.length){
            return f.apply(this, args);
        }else{
            return function(...args2){
                return curried.apply(this, args.concat(args2));
            }
        }
    }
}


const sum2 = (a, b, c, d) => (a + b + c + d);
const curriedSum2 = curry2(sum2);
console.log(curriedSum2(1)(2)(3)(4));