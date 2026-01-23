import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MenuItemDAO {

    public static void save(MenuItem item) {
        String sql = "INSERT INTO menuitem(name, price) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<MenuItem> findAll() {
        List<MenuItem> menu = new ArrayList<>();
        String sql = "SELECT id, name, price FROM menuitem";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                menu.add(new MenuItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }



    public static void updatePrice(String name, double price) {
        String sql = "UPDATE menuitem SET price = ? WHERE name = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setString(2, name);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void delete(String name) {
        String sql = "DELETE FROM menuitem WHERE name = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<MenuItem> sortByPrice() {
        List<MenuItem> menu = findAll();
        menu.sort(Comparator.comparingDouble(MenuItem::getPrice));
        return menu;
    }

    public static List<MenuItem> filterByMaxPrice(double maxPrice) {
        List<MenuItem> filtered = new ArrayList<>();
        for (MenuItem item : findAll()) {
            if (item.getPrice() <= maxPrice) {
                filtered.add(item);
            }
        }
        return filtered;
    }
}

