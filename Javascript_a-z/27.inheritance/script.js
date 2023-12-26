class Person { // 클래스 선언
    constructor(name, email){ // 생성자
        this.name = name;
        this.email = email;
    }

    introduce(){ // 메소드
        console.log(`My name is ${this.name}`);
    }
}

class Client extends Person { // Person을 상속받음
    constructor(name, email, phone, address){ // 생성자
        super(name, email); // 부모의 생성자를 호출
        this.phone = phone;
        this.address = address;
    }
}

const john = new Person('John', 'john@example.com', '010-0000-0000', 'Seoul');
console.log(john.introduce()); // My name is John