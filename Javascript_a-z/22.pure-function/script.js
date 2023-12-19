// let x = 0;
// const numberUp = () => x += 1;
// console.log(numberUp());
// console.log(x);

// let x = 0;
// const pureNumberUp = (num) => num += 1;
// console.log(pureNumberUp(x));
// console.log(x);

const alphabetArray = ['A', 'B'];
// const addItemToArray = (originalArray, newItem) => {
//     originalArray.push(newItem);
//     return originalArray;
// }

// console.log(addItemToArray(alphabetArray, 'C'));
// console.log(alphabetArray);

const pureAddItemToArray = (originalArray, newItem) => {
    return [...originalArray, newItem];
}
console.log(pureAddItemToArray(alphabetArray, 'C'));
console.log(alphabetArray)