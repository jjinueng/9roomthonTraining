// method => Object
// method에서는 해당 객체를 가리킨다.

const audio = {
    title: 'a',
    play() {
        console.log('play this', this);
    }
}

audio.play();

// 위 예시에서는 audio.play()에서 this는 audio를 가리킨다.
// 결과값은 {title: "a", play: ƒ}이다.

audio.stop = function () {
    console.log('stop this', this);
}

audio.stop();

// 같은 객체를 가리키기 때문에 결과값도 같음

// Function => Global (window, global)
// function에서는 전역객체를 가리킨다.
// 전역객체는 브라우저에서는 window, node에서는 global이다.

function playAudio() {
    console.log(this);
}

playAudio();

// 결과값은 window이다.

// Constructor Function => {}
// 빈 객체를 가리킨다.

function Audio(title) {
    this.title = title;
    console.log(this);
}

const audio1 = new Audio('a');

// this가 가리키는 것은 a이다.
// 결과값은 {title: "a"}이다.

const audio2 = {
    title: 'audio',
    categories: ['rock', 'hiphop', 'pop'],
    displayCategories() {
        this.categories.forEach(function (category) { // 해당 줄의 this는 method를 가리킨다.
            console.log('title:' + this.title, 'category:' + category); // this.title이 undefined이다. 함수 안에 있기 때문에 전역객체를 가리킨다.
        }) // this.title이 다른 걸 가리키게 하고 싶다면, 두번째 매개변수(}와 ) 사이)에 넣어주면 된다. ex) {title: 'audio'}
        // 두번째 매개변수에 this를 넣는다면, method를 가리키기 때문에 this.title에서 audio를 출력하게 된다.
    }
}

audio2.displayCategories();

// 화살표 함수 ==> this는 상위 스코프의 this를 가리킨다.
// 이를 Lexical this라고 한다.

const audio3 = {
    title: 'audio',
    categories: ['rock', 'hiphop', 'pop'],
    displayCategories() {
        this.categories.forEach((category) => { 
            console.log(this);
        }) 
        
    }
}

audio3.displayCategories();