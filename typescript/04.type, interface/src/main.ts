// interface Animal {
//     name: string;
// }

// interface Bear extends Animal {
//     honey: boolean;
// }


// type Animal = {
//     name: string;
// }

// type Bear = Animal & {
//     honey: boolean;
// }

// const bear1: Bear = {
//     name: 'honey bear',
//     honey: true
// }


interface Animal {
    name: string;
}

interface Animal { // interface는 확장이 가능하다. (병합)
    honey: boolean;
}

const bear1: Animal = {
    name: 'honey bear',
    honey: true
}