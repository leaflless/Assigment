import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Restaurant restaurant = new Restaurant("Rest", "Astana, Turan 10");

        restaurant.addMenuItem(new MenuItem("Pizza", 3000));
        restaurant.addMenuItem(new MenuItem("Burger", 2000));
        restaurant.addMenuItem(new MenuItem("Pasta", 2500));

        restaurant.sortMenuByPrice();
        restaurant.showMenu();

        System.out.print("Dish name: ");
        String dishName = scanner.nextLine();

        MenuItem item = restaurant.findByName(dishName);
        if (item != null) {
            System.out.print("Quantity: ");
            int qty = scanner.nextInt();

            Order order = new Order(1, item, qty);
            restaurant.addOrder(order);

            System.out.println("Order created:");
            restaurant.showOrders();
        } else {
            System.out.println("Dish not found");
        }
    }
}

