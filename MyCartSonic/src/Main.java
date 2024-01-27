



//### 과제 설명
//
//  쇼핑몰에서 자주 사용하는 기능인 ‘장바구니’ 기능을 java로 구현합니다.
//  HashSet을 사용하여 상품 목록을 만들고, HashMap을 사용하여 장바구니에 상품을 담습니다.
//
//  구현하기 위해서는 다음과 같은 클래스가 필요합니다.
//
//  - 상품
//  - 상품의 key, 이름, 가격을 필드로 가지고 있습니다.
//  - equals() 및 hashCode() 함수를 override 해야합니다. HashSet을 사용할때 중복된 상품이 상품목록에 들어가지 않게 이 함수들이 사용되어야 합니다.
//  -
//
//  장바구니: 두개 이상의 상품을 담을 수 있어야합니다. (ex. 우유 2개, 화장지 3개)
//  - items를 가지고 있습니다.
//
//  다음과 같은 함수를 가지고 있어야 합니다.
//
//  - showItems()
//  - addProduct()
//  - removeProduct()
//
//  장바구니 어플리케이션은 다음과 같은 기능을 제공해야합니다.
//
//  1. 상품을 입력하여 상품목록을 구성합니다.
//  2. 장바구니에 상품을 담습니다. 이때, 상품을 몇개 담을것인지 또한 명시되어야 합니다
//
//  ex. 우유 2개 담기, 사과 1개 담기
//
//  3. 장바구니에서 상품을 제거합니다. 이때, 몇개의 상품을 뺄것인지 명시되어야 합니다.
//
//  ex. 우유 1개 빼기
//
//  4. 장바구니에 담겨있는 상품들의 이름과 수량을 출력해야합니다.

import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    //상품 목록을 생성

    Set<Product> productSet = new HashSet<>();

    Product product1 = new Product("1", "칫솔", 1000);
    Product product2 = new Product("2", "치약", 2000);

    productSet.add(product1);
    productSet.add(product2);

    //상품 목록 잘 들어갔는지 확인
    System.out.println(" 상품 목록 확인!!");
    for (Product product : productSet) {
      System.out.println(product.getName() + " : " + product.getPrice());
    }


    //장바구니 생성

    Cart myCart = new Cart();

    myCart.addProduct(product1, 2);
    myCart.addProduct(product2, 3);

    // 상품 장바구니에서 제거

    myCart.removeProduct(product1, 2);
    myCart.removeProduct(product2, 1);

    // 장바구니의 상품 모두 출력
    myCart.showItems();

    //추가테스트

    myCart.removeProduct(product1, 1);
    System.out.println(myCart.showItemsStream());


    myCart.addProduct(product1, 1);
    System.out.println(myCart.showItemsStream());



  }
}