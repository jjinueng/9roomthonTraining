// function fetchData(){
//     return new Promise((resolve, reject) => {
//         // 비동기 요청
//         const success = true;
//         if(success){
//             resolve('성공');
//         } else {
//             reject('실패');
//         }
//     });
// }

// fetchData()
//     .then((response) => {
//         console.log(response);
//     })
//     .catch((error) => {
//         console.log(error);
//     })

// fetch('https://jsonplaceholder.typicode.com/todos/1') // promise를 지원하는 함수
//     .then((response1) => response1.json())
//     .then((json1) => console.log(json1))
//     .then(() => fetch('https://jsonplaceholder.typicode.com/todos/2'))
//     .then((response2) => response2.json())
//     .then((json2) => console.log(json2))
//     .catch((error) => console.log(error)) // 에러가 발생하면 catch문으로 이동
//     .finally(() => console.log('작업 끝')); // 성공하든 실패하든 무조건 실행

async function makeRequest(){
    try{
        const response1 = await fetch('https://jsonplaceholder.typicode.com/todos/1');
        const jsonResponse1 = await response1.json();
        console.log('jsonPesponse1',jsonResponse1);
        const response2 = await fetch('https://jsonplaceholder.typicode.com/todos/2');
        const jsonResponse2 = await response2.json();
        console.log('jsonPesponse2',jsonResponse2);
    } catch (error){
        console.log(error);
    } finally {
        console.log('작업 끝');
    }

}