
// 스택 : 한 쪽 끝에서만 데이터를 넣고 뺄 수 있는 자료 구조
// 후입 선출 Last in First out 형태의 선형 자료 구조

import java.util.Stack;

public class MyStack<T> {
  public  MyLinkedList<T> list = new MyLinkedList<>();

  //push
  public void push(T item) {
    list.add(item);
  }
  //pop
  public T pop() {
    //예외처리:: 아무것도 없는데 꺼내려고 하면 안됨!!
    if (list.isEmpty()) {
      throw new IllegalStateException("stack이 비었다!!");
    }
    //pop()  사이즈 조정 필요! 가장 마지막 값을 pop을 해줘야하니까 마지막 값을 없애줍니다.
    int lastIndex = list.size()-1;
    T top = list.get(lastIndex);
    list.delete(lastIndex);
    return top;
  }

  //peek
  public T peek(){
    if (list.isEmpty()) {
      throw new IllegalStateException("stack이 비었다!!");
    }
    int lastIndex = list.size() -1;
    T top = list.get(lastIndex);
    return top;
  }

}
