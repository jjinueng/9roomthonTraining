// for
for(let i=0; i<10; i++){
    if(i===3){
        console.log('It is 3');
    }
    if(i===5){
        console.log('5 Stop the loop');
        break;
    }
    console.log('Number ' + i);
}

// for/in
const user = {
    name: 'Han',
    province: '경기도',
    city: '성남시'
}

for(let x in user){
    console.log(`${x} : ${user[x]}`);
}

// while
let i=0;
while(i<10){
    console.log('Number ' + i);
    i++;
}

// do while
let j=0;

do{
    console.log('Number ' + j);
    j++;
}

while(j<10); // 조건이 false여도 최소 한번은 실행