package test.order;

public class Order {

    Long memberId;
    String itemName;
    int itemPrice;
    int discountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public Long memberId() {
        return memberId;
    }

    public String itemName() {
        return itemName;
    }

    public int itemPrice() {
        return itemPrice;
    }

    public int discountPrice() {
        return discountPrice;
    }
}
