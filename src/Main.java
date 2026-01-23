public class Main {
    public static void main(String[] args) {

        MenuItem pizza = new MenuItem(1,"Pizza", 3000);
        MenuItem burger = new MenuItem(2,"Burger", 2000);
        MenuItem pasta = new MenuItem(3,"Pasta", 2500);

        MenuItemDAO.save(pizza);
        MenuItemDAO.save(burger);
        MenuItemDAO.save(pasta);

        Order order1 = new Order(101, pizza, 2);
        Order order2 = new Order(102, burger, 1);
        Order order3 = new Order(103,pasta,2);

        OrderDAO.save(order1);
        OrderDAO.save(order2);
        OrderDAO.save(order3);

        OrderDAO.updateQuantity(101, 3);

        MenuItemDAO.updatePrice("Pizza", 3500);

        System.out.println("MENU FROM DATABASE:");
        MenuItemDAO.findAll().forEach(System.out::println);
    }
}



