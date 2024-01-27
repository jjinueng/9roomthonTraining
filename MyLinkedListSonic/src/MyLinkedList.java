import java.util.Iterator;
import java.util.NoSuchElementException;

//LinkedList 자료구조를 학습하고 간단한 MyLinkedList 를 구현합니다.
// 우리가 만드는 MyLinkedList 는 다음과 같은 메서드를 제공합니다.
//add() : MyLinkedList 의 마지막 노드에 data 를 추가 할 수 있습니다.
// get(index i): MyLinkedList 의 i 번째 노드의 data 를 return 합니다.
// delete(index i): MyLinkedList 의 i 번째 노드의 데이터를 삭제합니다.
//
// 위를 api를 제공하면서, data 의 타입은 LinkedList 를 생성할 때 정할 수 있도록 제네릭으로 구현합니다.
public class MyLinkedList<T> implements Iterable<T>{

  private Node<T> head;

  private int size = 0;

  public void add(T data){
    //데이터 생성
    Node<T> node = new Node<>(data);

    //LinkedList가 비어있는 경우
    if (size == 0) {
      head = node;
    }//비어있지않은 경우 => 데이터가 1개 이상인 경우
    else {
      //마지막 노드 뒤로 데이터를 넣어줘야 합니다.
      //마지막 노드를 탐색!!
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      //현재==current 노드는 가장 마지막 노드가 위치하고 있음
      // 마지막 노드를 next에 추가를 해줌
      current.setNext(node);
    }

    this.size++;

  }
  //TODO get(index i)
  public T get(int index) {
    //linked list 양 끝 값에 대한 예외처리
    if (index <0 ||this.size <= index) {
      throw new IndexOutOfBoundsException();
    }

    // index 노드를 찾자!
    Node<T> current = this.head;
    for (int i = 0; i< index; i++){
      current = current.getNext();
    }
    return current.getData();

  }
  //TODO delete(index i)
  // 중간 값을 삭제 !! 그만큼 노드를 가리키는 주소를 정리를 해줘야함
  // 1 -> 2 ->  4
  // 김   이    최
  // 3(박)을 삭제하면 2->4로 바로 가야합니다

  public void delete(int index) {
    //양 끝값 경계에 대한 예외처리
    if (index <0 ||this.size <= index) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      head = head.getNext();
    } else {
      //index번째의 노드를 찾아야함
      Node<T> current = this.head;
      for (int i = 0; i< index - 1 ; i++){
        current = current.getNext();
      }
      //직전 노드의 next를 i+1 (다음 노드) 번째 노드로 바꿔준다.
      current.setNext(current.getNext().getNext());

    }
    this.size--;

  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      private Node<T> current = head;

      // 맨 처음 == head 부터 순회
      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        // 다음 노드가 있는 먼저 확인하고, 있으면 동작
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        T data = current.getData();
        current = current.getNext();
        return data;
      }
    };
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

}
