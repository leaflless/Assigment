package org.example.db;

import org.example.model.MenuItem;
import org.example.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDB {

    public static void save(Order order) {
        String sql = """
                INSERT INTO orders(menu_item, price, quantity)
                VALUES (?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, order.getItem().getName());
            ps.setDouble(2, order.getItem().getPrice());
            ps.setInt(3, order.getQuantity());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT id, menu_item, price, quantity FROM orders";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                MenuItem item = new MenuItem(
                        rs.getString("menu_item"),
                        rs.getDouble("price")
                );

                orders.add(new Order(
                        rs.getInt("id"),
                        item,
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static void delete(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
