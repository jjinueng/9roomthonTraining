let val;

const list = document.querySelector('ul.list-group');
const listItem = document.querySelector('li.list-group-item:first-child');

console.log('list', list);
console.log('listItem', listItem);

val = list.childNodes;
console.log('val', val); // console 창을 보면 text가 있음, NodeList 변환은 line break도 포함

val = list.childNodes[0];
console.log('val', val);

val = list.childNodes[0].nodeName;
console.log('val', val);

val = list.childNodes[0].nodeType;
console.log('val', val);

// 1 - Element
// 2 - Attribute (deprecated)
// 3 - Text node
// 8 - Comment (주석)
// 9 - Document itself
// 10 - Doctype

// children element nodes 반환

val = list.children; // HTMLCollection 반환 (line break 제외)
console.log('val', val);

val = list.children[1];
console.log('val', val);

list.children[1].textContent = 'Hi';

// firstChild
val = list.firstChild; // list.firstChid === list.childNodes[0]
console.log('val', val);

val = list.firstElementChild; // list.firstElementChild === list.children[0]
console.log('val', val);

// lastChild
val = list.lastChild; // list.lastChild === list.childNodes[list.childNodes.length - 1]
console.log('val', val);

val = list.lastElementChild; // list.lastElementChild === list.children[list.children.length - 1]
console.log('val', val);

// count child elements
val = list.childElementCount;
console.log('val', val);

// parent node 반환
val = listItem.parentNode;
console.log('val', val);

val = listItem.parentElement;
console.log('val', val);

val = listItem.parentElement.parentElement;
console.log('val', val);

// nextSibling 반환
val = listItem.nextSibling; // line break 포함
console.log('val', val);

val = listItem.nextElementSibling; // line break 제외
console.log('val', val);

val = listItem.nextElementSibling.nextElementSibling;
console.log('val', val);

val = listItem.nextElementSibling.nextElementSibling.previousElementSibling;
console.log('val', val);

// previousSibling 반환
val = listItem.previousSibling; // line break 포함
console.log('val', val);

val = listItem.previousElementSibling; // line break 제외   
console.log('val', val); // null

// childNodes는 배열이 아님 (NodeList)
// 따라서 forEach 사용 불가

Array.from(list.childNodes); // 배열로 변환, forEach 사용 가능
