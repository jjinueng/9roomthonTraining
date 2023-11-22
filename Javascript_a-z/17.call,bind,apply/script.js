// call();
const fullName1 = function(){
    console.log(this.firstName + " " + this.lastName);
}

fullName1(); // 출력 시 undefined undefined
// 이를 해결 하려면?
const person1 = {
    firstName: "John",
    lastName: "Smith"
}

fullName1.call(person1); // 출력 시 John Smith

// fullName.call(person1, "Oslo", "Norway");
// person1 뒤에 인수를 넣으면 const fullName = function() 에서 매개변수로 가져올 수 있음
// const fullName = function(city, country){
//     console.log(this.firstName + " " + this.lastName, city, country);
// } 로 바꾸면 John Smith Oslo Norway가 출력됨

// apply();

const fullName2 = function(city, country){
        console.log(this.firstName + " " + this.lastName, city, country);
    } 


const person2 = {
    firstName: "John",
    lastName: "Smith"
}

fullName2.apply(person1, ["Oslo", "Norway"]); // call과 다른 점은 인수를 배열로 넣어야 한다는 것

// bind();
function func(language){
    if(language === "kor"){
        console.log(`language: ${this.korGreeting}`);
    }
    else{
        console.log(`language: ${this.engGreeting}`);
    }
}

const greeting = {
    korGreeting: "안녕하세요",
    engGreeting: "Hello"
}

const boundFunc = func.bind(greeting); // bind는 호출하지 않고 함수를 반환함, 따라서 변수에 할당해야 함
boundFunc("kor"); // language: 안녕하세요
boundFunc("eng"); // language: Hello