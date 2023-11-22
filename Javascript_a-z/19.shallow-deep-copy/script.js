// shallow copy - 얕은 복사

const aArray = [1, 2, 3];

// shallow copy with spread operator
const bArray = [...aArray, 4];
console.log('aArray', aArray);
console.log('bArray', bArray);
console.log('aArray === bArray: ' + (aArray === bArray)); // false

// shallow copy with Object.assign()
const cArray = Object.assign([], bArray);
console.log('cArray', cArray);
console.log('bArray === cArray: ' + (bArray === cArray)); // false
// 값은 같더라도 참조하는 위치가 다르기 때문에 === 에서는 false로 나옴

// Nested Arrays and Objects
cArray.push([5, 6, 7]);
console.log('cArray', cArray);
const dArray = [...cArray, 10]; // cArray의 값을 복사한 후 10을 추가
console.log('dArray', dArray);
dArray[4].push(8); // dArray의 4번째 인덱스에 8을 추가
console.log('cArray', cArray);
console.log('dArray', dArray);
// 중첩된 배열이나 객체는 얕은 복사를 하더라도 참조하는 위치가 같기 때문에
// 값이 변하면 같이 변함

// 얕은 동결

const aObject = {
    "a": "a",
    "b": "b",
    "cObject": {
        "a": 1, "b": 2
    }
}

Object.freeze(aObject);
aObject.a = "c";
console.log('aObject', aObject); // a가 c로 바뀌지 않음

//aObject.cObject.a = 3; // 이후에는
console.log('aObject', aObject); // cObject.a가 3으로 바뀜

// deep copy - 깊은 복사
// with JSON.parse(JSON.stringify())
const newObject = JSON.parse(JSON.stringify(aObject));
console.log('newObject', newObject);
aObject.cObject.a = 3; // 깊은 복사를 했기 때문에 newObject에는 영향을 주지 않음
console.log('aObject', aObject);
console.log('newObject', newObject);

// with nested spread operator
const newAObject = {...aObject, cObject:{...aObject.cObject}}; // 중첩이 되는 부분까지 얕은 복사
