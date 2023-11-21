// let val;

// val= document;
// console.log(val);

// val = document.baseURI;
// console.log(val);

// val = document.head;
// console.log(val);

// val = document.body;
// console.log(val);

// val = document.forms;
// console.log(val);

// val = document.forms[0];
// console.log(val);

// val = document.forms[0].id;
// console.log(val);

// val = document.forms[0].classList;
// console.log(val);

// val = document.forms[0].className;
// console.log(val);

// val = document.scripts;
// console.log(val);

// val = document.scripts[0].getAttribute('src');
// console.log(val);

const headerContainer = document.getElementById('header-container');
// headerContainer.style.display = 'none';
// console.log(headerContainer);

headerContainer.textContent = 'Text Content';
headerContainer.innerText = 'Inner Text';
headerContainer.innerHTML = '<h1>Inner HTML</h1>';

const items = document.getElementsByClassName('list-group-item'); // class 이름이 list-group-item인 모든 요소를 가져옴
console.log(items);

items[0].style.color = 'blue';
items[3].textContent = 'Hello';

let lists = document.getElementsByTagName('li'); // 태그 이름이 li인 모든 요소를 가져옴
console.log(lists);

lists = Array.from(lists);
console.log(lists);

lists.forEach((list, index) => {
    list.textContent = `${index} - List`;
}
);

const liOdd = document.querySelectorAll('li:nth-child(odd)'); // CSS 선택자를 이용하여 요소를 가져옴, 홀수번째 li
liOdd.forEach((li) => {
    li.style.background = 'gray';
});