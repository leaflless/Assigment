package org.example.ui;

import org.example.db.MenuItemDB;
import org.example.model.MenuItem;

import java.util.List;
import java.util.Scanner;

public class MenuUI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        while (true) {
            System.out.println("\n--- Menu CRUD ---");
            System.out.println("1) Create menu item");
            System.out.println("2) Read menu item by name");
            System.out.println("3) Read all menu items");
            System.out.println("4) Update price");
            System.out.println("5) Delete menu item");
            System.out.println("0) Back");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> create();
                case 2 -> readByName();
                case 3 -> readAll();
                case 4 -> update();
                case 5 -> delete();
                case 0 -> { return; }
                default -> System.out.println("Wrong choice!");
            }
        }
    }

    private static void create() {
        System.out.print("Item name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        MenuItemDB.save(new MenuItem(name, price));
        System.out.println("✔ Created");
    }

    private static void readByName() {
        System.out.print("Item name: ");
        String name = scanner.nextLine();

        List<MenuItem> items = MenuItemDB.findAll();
        items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Not found")
                );
    }

    private static void readAll() {
        MenuItemDB.findAll().forEach(System.out::println);
    }

    private static void update() {
        System.out.print("Item name: ");
        String name = scanner.nextLine();

        System.out.print("New price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        MenuItemDB.updatePrice(name, price);
        System.out.println("✔ Updated");
    }

    private static void delete() {
        System.out.print("Item name: ");
        String name = scanner.nextLine();

        MenuItemDB.delete(name);
        System.out.println("✔ Deleted");
    }
}
