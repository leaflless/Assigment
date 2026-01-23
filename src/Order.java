import java.util.Objects;

public class Order extends BaseEntity {
    private int itemid;
    private MenuItem item;
    private int quantity;
    private String itemName; // новое поле для названия блюда

    public Order(int itemid, MenuItem item, int quantity) {
        this.itemid = itemid;
        this.item = item;
        this.quantity = quantity;
        this.itemName = item.getName(); // сохраняем название при создании заказа
    }

    public int getItemid() { return itemid; }
    public MenuItem getItem() { return item; }
    public int getQuantity() { return quantity; }
    public String getItemName() { return itemName; } // геттер для названия

    public double calculateTotal() { return item.getPrice() * quantity; }

    @Override
    public String getInfo() {
        return "Order №" + itemid + ": " + itemName + " x" + quantity;
    }

    @Override
    public String toString() {
        return "Order{id=" + itemid + ", itemName='" + itemName + "', quantity=" + quantity + "}";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o instanceof Order) return false;
        Order order = (Order) o;
        return itemid == order.itemid;
    }

    @Override
    public int hashCode() { return Objects.hash(itemid); }
}
