let instance;
// 1. 생성자에서 하나의 인스턴스만 생성될 수 있게 로직 작성
class Counter{
    constructor(){
        if(instance){
            throw new Error('하나의 인스턴스만 생성할 수 있습니다.');
        }
        this.count = 0;
        instance = this;
    }

    getCount(){
        return this.count;
    }

    increment(){
        return this.count++;
    }

    decrement(){
        return this.count--;
    }
}

// 2. 객체 인스턴스 생성, 두번째 생성한 객체는 에러가 난다
const singletonCounterA = new Counter();
const CounterB = new Counter(); // Error: 하나의 인스턴스만 생성할 수 있습니다.

singletonCounterA.increment();

console.log(singletonCounterA.getCount());