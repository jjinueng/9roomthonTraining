public class Node<T> {

  private T data;
  private Node<T> next;

  //생성자
  public Node(T data) {
    this.data = data;
    this.next = null;
  }

  //Getter
  public T getData() {
    return data;
  }

  public Node<T> getNext() {
    return next;
  }

  //Setter
  public void setNext(Node<T> next) {
    this.next = next;
  }
}
