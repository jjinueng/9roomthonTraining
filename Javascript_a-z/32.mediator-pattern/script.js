class Participant {
    constructor(name) {
        this.name = name;
        this.chatroom = null;
        this.messages = [];
    }
    send(message, to) {
        this.chatroom.send(message, this, to);
    }

    receive(message, from) {
        this.messages.push({ message, from });
    }

    showMessages() {
        console.log(this.messages);
    }
}

class Chatroom { // mediator를 통해서 상대방에게 메시지를 보낸다.
    constructor() {
        this.participants = {};
    }

    enter(participant) {
        this.participants[participant.name] = participant;
        participant.chatroom = this;
    }

    send(message, participant, to) {
        this.participants[to.name].receive(message, participant);
    }
}

const chatRoom = new Chatroom();

const user1 = new Participant('user1');
const user2 = new Participant('user2');
const user3 = new Participant('user3');

chatRoom.enter(user1);
chatRoom.enter(user2);
chatRoom.enter(user3);

console.log(chatRoom);
console.log(user1);

user1.send('hello', user2);

console.log(chatRoom);