// element 생성
const li = document.createElement('li');

// 클래스 추가하기
li.className = 'list-group-item';

// id 추가하기
li.id = 'new-item';

// 속성 추가하기
li.setAttribute('name', 'New list item');

// link element 생성
const link = document.createElement('a'); // a 요소 생성

link.className = 'alarm-item';

link.innerHTML = '<i class="bi-alarm"></i>'; //link에 알람 아이콘 추가

li.appendChild(link); // li에 link 추가

document.querySelector('ul.list-group').appendChild(li); // list에 추가