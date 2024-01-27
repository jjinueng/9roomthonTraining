public class Main3 {
  public static void main(String[] args) {
    MyQueue<String> queue = new MyQueue<>();

    //enqueue
    queue.enqueue("김");
    queue.enqueue("이");
    queue.enqueue("박");
    queue.enqueue("최");

    //dequeue
    String item = queue.dequeue();
    System.out.println("Item = " + item);
    //peek
    String peekItem = queue.peek();
    System.out.println("peekItem = " + peekItem);

    //예외확인

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

  }
}
