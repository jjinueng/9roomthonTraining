// window.onload = function() {
//     // 문서가 load 될 때 이 함수를 실행
//     let text = document.getElementById("text"); // id가 text인 요소인 return

//     text.innerText = 'HTML 문서 loaded'; // text 요소의 텍스트를 변경
// }

// const aElement = document.querySelector('a');

// aElement.addEventListener('click', ()=>{
//     alert('a element clicked');
// });

// const buttonElement = document.querySelector('.btn2');

// buttonElement.addEventListener('click', ()=>{
//     let val;
//     val = event.target;

//     console.log(val);

//     val = event.target.id;
//     console.log(val);

//     val = event.target.className;
//     console.log(val);

//     val = event.target.classList;
//     console.log(val);

//     val = event.type;
//     console.log(val);

//     val = event.clientY;
//     console.log(val);

//     val = event.offsetY;
//     console.log(val);
// })

const submitBtn = document.querySelector('.submit-btn');
const form = document.querySelector('form');
const title = document.querySelector('h2');
const emailInput = document.getElementById('email');

// FORM EVENT
form.addEventListener('submit', handleEvent);
emailInput.addEventListener('keydown', handleEvent);


// EVENT
// submitBtn.addEventListener('click', handleEvent);
// submitBtn.addEventListener('dblclick', handleEvent);
// submitBtn.addEventListener('mousedown', handleEvent);
// submitBtn.addEventListener('mouseup', handleEvent);
// submitBtn.addEventListener('mouseenter', handleEvent);
// submitBtn.addEventListener('mouseleave', handleEvent);


function handleEvent(e) {
    if (e.type === 'submit') { e.preventDefault(); }
    console.log('Event Type: ' + e.type);
    // title.textContent = `Mouse X: ${e.offsetX} Mouse Y: ${e.offsetY}`;
    title.textContent = e.target.value;
}