package org.example.restaurant;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private final DataSource ds;

    public ItemRepository(DataSource ds) {
        this.ds = ds;
    }

    public List<Item> findAll() throws Exception {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items ORDER BY id";

        try (Connection con = ds.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Item i = new Item();
                i.id = rs.getInt("id");
                i.name = rs.getString("name");
                i.price = rs.getDouble("price");
                list.add(i);
            }
        }
        return list;
    }

    public Item findById(int id) throws Exception {
        String sql = "SELECT * FROM items WHERE id=?";
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException("Item with id=" + id + " not found");
            }

            Item i = new Item();
            i.id = rs.getInt("id");
            i.name = rs.getString("name");
            i.price = rs.getDouble("price");
            return i;
        }
    }

    public void save(Item item) throws Exception {
        String sql = "INSERT INTO items(name, price) VALUES (?, ?)";
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, item.name);
            ps.setDouble(2, item.price);
            ps.executeUpdate();
        }
    }

    public void update(int id, Item item) throws Exception {
        String sql = "UPDATE items SET name=?, price=? WHERE id=?";
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, item.name);
            ps.setDouble(2, item.price);
            ps.setInt(3, id);

            if (ps.executeUpdate() == 0) {
                throw new RuntimeException("Item with id=" + id + " not found");
            }
        }
    }

    public void delete(int id) throws Exception {
        String sql = "DELETE FROM items WHERE id=?";
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            if (ps.executeUpdate() == 0) {
                throw new RuntimeException("Item with id=" + id + " not found");
            }
        }
    }
}