/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.clase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andyc
 */
public class CalificacionDAO {
      // === INSERTAR ===
    public boolean insertar(Calificacion c) {
        String sql = "INSERT INTO calificaciones (estudiante_id, materia, nota, fecha) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getEstudianteId());
            ps.setString(2, c.getMateria());
            ps.setDouble(3, c.getNota());
            ps.setDate(4, c.getFecha());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar calificación: " + e.getMessage());
            return false;
        }
    }

    // === LISTAR HISTORIAL DE UN ESTUDIANTE ===
    public List<Calificacion> obtenerPorEstudiante(int estudianteId) {
        List<Calificacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM calificaciones WHERE estudiante_id = ? ORDER BY fecha DESC";
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, estudianteId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Calificacion(
                        rs.getInt("id"),
                        rs.getInt("estudiante_id"),
                        rs.getString("materia"),
                        rs.getDouble("nota"),
                        rs.getDate("fecha")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener calificaciones: " + e.getMessage());
        }
        return lista;
    }

    // === CALCULAR PROMEDIO DE UN ESTUDIANTE ===
    public double calcularPromedio(int estudianteId) {
        String sql = "SELECT AVG(nota) AS promedio FROM calificaciones WHERE estudiante_id = ?";
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, estudianteId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("promedio");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al calcular promedio: " + e.getMessage());
        }
        return 0.0;
    }

    // === JOIN: listar calificaciones con nombre del estudiante ===
    public void listarConEstudiante() {
        String sql = """
            SELECT c.id, e.nombre, e.apellido, c.materia, c.nota, c.fecha
            FROM calificaciones c
            INNER JOIN estudiantes e ON c.estudiante_id = e.id
            ORDER BY e.nombre;
        """;
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("--- Calificaciones con nombre del estudiante ---");
            while (rs.next()) {
                System.out.printf("ID: %d | %s %s | %s | Nota: %.2f | Fecha: %s%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("materia"),
                        rs.getDouble("nota"),
                        rs.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar calificaciones: " + e.getMessage());
        }
    }
}
