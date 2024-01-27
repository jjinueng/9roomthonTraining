public class Main2 {
  public static void main(String[] args) {

    MyStack<String> stack = new MyStack<>();

    //push
    stack.push("김");
    stack.push("이");
    stack.push("박");

    //pop
    String popItem = stack.pop();
    System.out.println("popItem = " + popItem);

    //peek
    String peekItem = stack.peek();
    System.out.println("peekItem = " + peekItem);


  }
}
