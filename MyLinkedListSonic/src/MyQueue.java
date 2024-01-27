public class MyQueue<T> {
  private MyLinkedList<T> list = new MyLinkedList<>();


  //enqueue
  public void enqueue(T item) {
    list.add(item);
  }

  //dequeue
  public T dequeue() {
    //예외처리:: 아무것도 없는데 꺼내려고하면 안됨!
    if(list.isEmpty()) {
      throw new IllegalStateException("queue empty!!");
    }

    T frontItem = list.get(0);
    list.delete(0);
    return frontItem;
  }

  //peek
  public T peek() {
    //예외처리:: 아무것도 없는데 꺼내려고하면 안됨!
    if(list.isEmpty()) {
      throw new IllegalStateException("queue empty!!");
    }

    T frontItem = list.get(0);
    return frontItem;
  }

}
