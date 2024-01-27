//LinkedList 자료구조를 학습하고 간단한 MyLinkedList 를 구현합니다.
// 우리가 만드는 MyLinkedList 는 다음과 같은 메서드를 제공합니다.
//add() : MyLinkedList 의 마지막 노드에 data 를 추가 할 수 있습니다. get(index i): MyLinkedList 의 i 번째 노드의 data 를 return 합니다. delete(index i): MyLinkedList 의 i 번째 노드의 데이터를 삭제합니다.
//
// 위를 api를 제공하면서, data 의 타입은 LinkedList 를 생성할 때 정할 수 있도록 제네릭으로 구현합니다.

// 연결리스트 -> 각 노드 가 *데이터* 포인터!! 를 가지고 한 줄로 연결되어서 데이터를 저장하는 자료 구조
public class Main {
  public static void main(String[] args) {
    MyLinkedList<String> myLinkedList = new MyLinkedList<>();

    //add
    myLinkedList.add("김");
    myLinkedList.add("이");
    myLinkedList.add("박");
    myLinkedList.add("최");

    //get
    System.out.println("-- get !!!--");
    System.out.println(myLinkedList.get(0));
    System.out.println(myLinkedList.get(1));
    System.out.println(myLinkedList.get(2));
    System.out.println(myLinkedList.get(3));

    //delete
    System.out.println("delete!!!!");
    myLinkedList.delete(2);

//    for (int i = 0 ; i < 3 ; i++) {
//      System.out.println(myLinkedList.get(i));
//    }

    for (String item: myLinkedList) {
      System.out.println(item);
    }
//    - Iterator interface 를 implements 한 후에 구현하여 for-each 로 순회 가능하도록 해봅시다.
//    - MyLinkedList 를 이용해서 Queue 와 Stack 을 구현해봅시다.


  }
}