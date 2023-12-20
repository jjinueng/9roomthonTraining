let user = {
    name: "John",
    age: 45,
    email: "sdf"
}

console.log(user.name);
console.log(user.hasOwnProperty('email')); // 없으면 false 있으면 true

function Person(name, email, birthday){
    const person = Object.create(personsPrototype);
    this.name = name;
    this.email = email;
    this.birthday = new Date(birthday);
    return person;
}

const personsPrototype = {
    calculateAge(){
        const diff = Date.now() - this.birthday.getTime();
        const ageDate = new Date(diff);
        return Math.abs(ageDate.getUTCFullYear()-1970);
    }


}

// Person.prototype.calculateAge = function(){
//     const diff = Date.now() - this.birthday.getTime();
//     const ageDate = new Date(diff);
//     return Math.abs(ageDate.getUTCFullYear()-1970);
// }

const john = new Person('John', 'john@example.com', '7-10-91')
const han = new Person('Han', 'han@example.com', '2-11-91')
console.log(john)
console.log(han)