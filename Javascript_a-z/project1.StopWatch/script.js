const appendTens = document.getElementById('tens');
const appendSeconds = document.getElementById('seconds');
const buttonStart = document.getElementById('button-start');
const buttonStop = document.getElementById('button-stop');
const buttonReset = document.getElementById('button-reset');

let seconds = 0;
let tens = 0;
let interval;

buttonStart.onclick = function () {
    interval = setInterval(startTimer, 10);
}

buttonStop.onclick = function () {
    clearInterval(interval);
}

buttonReset.onclick = function () {
    clearInterval(interval);
    seconds = 0;
    tens = 0;
    appendSeconds.innerText = seconds;
    appendTens.innerText = tens;
}
function startTimer() {
    tens++;

    if(tens > 99){
        seconds++;
        appendSeconds.innerText = seconds;
        tens = 0;
        appendTens.innerText = tens;
    } else{
        appendTens.innerText = tens;
    }
}

