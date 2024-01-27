import java.util.Objects;

//  - 상품
//  - 상품의 key, 이름, 가격을 필드로 가지고 있습니다.
//  - equals() 및 hashCode() 함수를 override 해야합니다.
//  HashSet을 사용할때 중복된 상품이 상품목록에 들어가지 않게 이 함수들이 사용되어야 합니다.
//  -
public class Product {

  private String key;
  private String name;
  private int price;

  public Product(String key, String name, int price) {
    this.key = key;
    this.name = name;
    this.price = price;
  }

  public String getKey() {
    return key;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Product product = (Product)o;
    return price == product.price && Objects.equals(key, product.key) && Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, name, price);
  }
}
