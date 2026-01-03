import java.util.Objects;

public class Order extends BaseEntity {
    private int id;
    private MenuItem item;
    private int quantity;

    public Order(int id, MenuItem item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return item.getPrice() * quantity;
    }

    @Override
    public String getInfo() {
        return "Order №" + id + ": " + item.getName() + " x" + quantity;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", item=" + item + ", quantity=" + quantity + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
