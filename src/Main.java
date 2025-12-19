public class Main {
    public static void main(String[] args){
        Restaurant restaurant = new Restaurant(
                "Rest",
                "Astana, Turan 10"
        );
        MenuItem pizza = new MenuItem("Pizza", 3000);
        MenuItem burger = new MenuItem("Burger", 2000);

        Order order1 = new Order(1, pizza, 2);
        Order order2 = new Order(2, burger, 1);

        restaurant.displayRestaurant();

        pizza.displayInfo();
        burger.displayInfo();

        System.out.println("Order 1: " + order1.calculateTotal());
        System.out.println("Order 2: " + order2.calculateTotal());

        if (order1.calculateTotal() > order2.calculateTotal()) {
            System.out.println("Order 1 is more expansive");
        } else {
            System.out.println("Order 2 is more expansive");
        }
    }
}

