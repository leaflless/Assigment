import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDAO {

    public static void save(Order order) {
        String sql = "INSERT INTO orders(itemid, itemname, quantity) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, order.getItem().getId());
            ps.setString(2, order.getItem().getName());
            ps.setInt(3, order.getQuantity());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateQuantity(int itemid, int newQuantity) {
        String sql = "UPDATE orders SET quantity = ? WHERE itemid = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, newQuantity);
            ps.setInt(2, itemid);
            ps.executeUpdate();

            System.out.println("Order updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int itemid) {
        String sql = "DELETE FROM orders WHERE itemid = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, itemid);
            ps.executeUpdate();

            System.out.println("Order deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
