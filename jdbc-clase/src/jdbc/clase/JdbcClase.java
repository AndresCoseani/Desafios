package jdbc.clase;

import java.util.List;

public class JdbcClase {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTION DE ESTUDIANTES ===\n");
        
        // Probar la conexión
        dbConexionEscuela.probarConexion();
        System.out.println();
        
        // Crear instancia del DAO
        estudianteDAO dao = new estudianteDAO();
        
        // 1. INSERTAR estudiantes
        System.out.println("--- Insertando estudiantes ---");
        estudiante est1 = new estudiante("Juan", "Perez", "juan.perez@mail.com", 20);
        estudiante est2 = new estudiante("Maria", "Gonzalez", "maria.g@mail.com", 22);
        estudiante est3 = new estudiante("Carlos", "Rodriguez", "carlos.r@mail.com", 19);
        
        if (dao.insertar(est1)) System.out.println("Estudiante 1 insertado");
        if (dao.insertar(est2)) System.out.println("Estudiante 2 insertado");
        if (dao.insertar(est3)) System.out.println("Estudiante 3 insertado");
        System.out.println();
        
        // 2. LISTAR todos los estudiantes
        System.out.println("--- Lista de todos los estudiantes ---");
        List<estudiante> estudiantes = dao.obtenerTodos();
        for (estudiante est : estudiantes) {
            System.out.println(est);
        }
        System.out.println();
        
        // 3. BUSCAR un estudiante por ID
        System.out.println("--- Buscando estudiante con ID 2 ---");
        estudiante encontrado = dao.obtenerPorId(2);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        }
        System.out.println();
        
        // 4. ACTUALIZAR un estudiante
        System.out.println("--- Actualizando estudiante ---");
        if (encontrado != null) {
            encontrado.setEdad(23);
            encontrado.setEmail("maria.gonzalez.nuevo@mail.com");
            if (dao.actualizar(encontrado)) {
                System.out.println("Estudiante actualizado correctamente");
                System.out.println("Nuevo estado: " + dao.obtenerPorId(encontrado.getId()));
            }
        }
        System.out.println();
        
        // 5. ELIMINAR un estudiante
        System.out.println("--- Eliminando estudiante con ID 3 ---");
        if (dao.eliminar(3)) {
            System.out.println("Estudiante eliminado correctamente");
        }
        System.out.println();
        
        // Listar estudiantes finales
        System.out.println("--- Lista final de estudiantes ---");
        estudiantes = dao.obtenerTodos();
        for (estudiante est : estudiantes) {
            System.out.println(est);
        }
    }    
}
