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
public class CategoriaDAO {
     public void agregarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";
        try (Connection con = dbConnection.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
            System.out.println("✅ Categoría agregada correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar categoría: " + e.getMessage());
        }
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Connection con = dbConnection.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Categoria c = new Categoria(rs.getInt("id"), rs.getString("nombre"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar categorías: " + e.getMessage());
        }
        return lista;
    }
}
