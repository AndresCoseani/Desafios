package jdbc.clase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) para operaciones CRUD de Estudiantes
 * Separa la lógica de acceso a datos del resto de la aplicación
 */
public class estudianteDAO {
    
    /**
     * Inserta un nuevo estudiante en la base de datos
     * @param estudiante objeto Estudiante a insertar
     * @return true si la inserción fue exitosa
     */
    public boolean insertar(estudiante estudiante) {
        String sql = "INSERT INTO estudiantes (nombre, apellido, email, edad) VALUES (?, ?, ?, ?)";
        
        // Try-with-resources cierra automáticamente los recursos
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Asignar valores a los parámetros de la consulta
            pstmt.setString(1, estudiante.getNombre());
            pstmt.setString(2, estudiante.getApellido());
            pstmt.setString(3, estudiante.getEmail());
            pstmt.setInt(4, estudiante.getEdad());
            
            // Ejecutar la inserción
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al insertar estudiante: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Obtiene todos los estudiantes de la base de datos
     * @return Lista de estudiantes
     */
    public List<estudiante> obtenerTodos() {
        List<estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes ORDER BY id";
        
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            // Iterar sobre los resultados
            while (rs.next()) {
                estudiante est = new estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getInt("edad")
                );
                estudiantes.add(est);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al obtener estudiantes: " + e.getMessage());
        }
        
        return estudiantes;
    }
    
    /**
     * Busca un estudiante por su ID
     * @param id identificador del estudiante
     * @return objeto Estudiante o null si no se encuentra
     */
    public estudiante obtenerPorId(int id) {
        String sql = "SELECT * FROM estudiantes WHERE id = ?";
        
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new estudiante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getInt("edad")
                    );
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error al buscar estudiante: " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * Actualiza los datos de un estudiante existente
     * @param estudiante objeto con los nuevos datos
     * @return true si la actualización fue exitosa
     */
    public boolean actualizar(estudiante estudiante) {
        String sql = "UPDATE estudiantes SET nombre=?, apellido=?, email=?, edad=? WHERE id=?";
        
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, estudiante.getNombre());
            pstmt.setString(2, estudiante.getApellido());
            pstmt.setString(3, estudiante.getEmail());
            pstmt.setInt(4, estudiante.getEdad());
            pstmt.setInt(5, estudiante.getId());
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar estudiante: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Elimina un estudiante de la base de datos
     * @param id identificador del estudiante a eliminar
     * @return true si la eliminación fue exitosa
     */
    public boolean eliminar(int id) {
        String sql = "DELETE FROM estudiantes WHERE id = ?";
        
        try (Connection conn = dbConexionEscuela.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar estudiante: " + e.getMessage());
            return false;
        }
    }
}
