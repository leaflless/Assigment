package org.example;

import org.example.ui.MenuUI;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---- Restaurant CRUD ----");
            System.out.println("1) Menu CRUD");
            System.out.println("0) Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> MenuUI.start();
                case 0 -> {
                    System.out.println("Bye");
                    return;
                }
                default -> System.out.println("Wrong choice");
            }
        }
    }
}

