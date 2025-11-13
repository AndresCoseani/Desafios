/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.clase.biblioteca;
import jdbc.clase.biblioteca.libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jdbc.clase.biblioteca.dbConnection;
/**
 *
 * @author andyc
 */
public class libroDAO {
      // CREATE
    public void agregarLibro(libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, año_publicacion, isbn, disponible) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = dbConnection.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAñoPublicacion());
            ps.setString(4, libro.getIsbn());
            ps.setBoolean(5, libro.isDisponible());
            ps.executeUpdate();
            System.out.println("✅ Libro agregado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar libro: " + e.getMessage());
        }
    }

    // READ - listar todos
    public List<libro> listarLibros() {
        List<libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection con = dbConnection.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                libro l = new libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("año_publicacion"),
                    rs.getString("isbn"),
                    rs.getBoolean("disponible")
                );
                lista.add(l);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar libros: " + e.getMessage());
        }
        return lista;
    }

    // READ - buscar por autor
    public List<libro> buscarPorAutor(String autor) {
        List<libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE autor LIKE ?";
        try (Connection con = dbConnection.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + autor + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                libro l = new libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("año_publicacion"),
                    rs.getString("isbn"),
                    rs.getBoolean("disponible")
                );
                lista.add(l);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar libros por autor: " + e.getMessage());
        }
        return lista;
    }

    // READ - listar solo disponibles
    public List<libro> listarDisponibles() {
        List<libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE disponible = TRUE";
        try (Connection con = dbConnection.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                libro l = new libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("año_publicacion"),
                    rs.getString("isbn"),
                    rs.getBoolean("disponible")
                );
                lista.add(l);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar disponibles: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public void actualizarLibro(libro libro) {
        String sql = "UPDATE libros SET titulo=?, autor=?, año_publicacion=?, isbn=?, disponible=? WHERE id=?";
        try (Connection con = dbConnection.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAñoPublicacion());
            ps.setString(4, libro.getIsbn());
            ps.setBoolean(5, libro.isDisponible());
            ps.setInt(6, libro.getId());
            ps.executeUpdate();
            System.out.println("✅ Libro actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar libro: " + e.getMessage());
        }
    }

    // DELETE
    public void eliminarLibro(int id) {
        String sql = "DELETE FROM libros WHERE id=?";
        try (Connection con = dbConnection.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Libro eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar libro: " + e.getMessage());
        }
    }
}
