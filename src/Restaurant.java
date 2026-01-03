import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private List<MenuItem> menu = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void showMenu() {
        menu.forEach(System.out::println);
    }

    public void sortMenuByPrice() {
        menu.sort(Comparator.comparingDouble(MenuItem::getPrice));
    }

    public MenuItem findByName(String name) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void showOrders() {
        orders.forEach(o ->
                System.out.println(o.getInfo() + ", total = " + o.calculateTotal())
        );
    }
}
