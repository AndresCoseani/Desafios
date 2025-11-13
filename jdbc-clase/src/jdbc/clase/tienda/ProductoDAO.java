/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.clase.tienda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andyc
 */
public class ProductoDAO {
     public void agregarProducto(Producto p) {
        String sql = "INSERT INTO productos (nombre, precio, stock, categoria_id) VALUES (?, ?, ?, ?)";
        try (Connection con = dbConnection.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getCategoriaId());
            ps.executeUpdate();
            System.out.println("✅ Producto agregado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar producto: " + e.getMessage());
        }
    }

    // === MÉTODO ESPECIAL: JOIN productos + categorías ===
    public void listarProductosConCategoria() {
        String sql = """
            SELECT p.id, p.nombre AS producto, p.precio, p.stock, c.nombre AS categoria
            FROM productos p
            INNER JOIN categorias c ON p.categoria_id = c.id
        """;
        try (Connection con = dbConnection.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("=== Productos con sus categorías ===");
            while (rs.next()) {
                System.out.printf("ID: %d | %s | $%.2f | Stock: %d | Categoría: %s%n",
                        rs.getInt("id"),
                        rs.getString("producto"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getString("categoria"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar productos con categoría: " + e.getMessage());
        }
    }
}
