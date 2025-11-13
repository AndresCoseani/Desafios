/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.clase.biblioteca;

/**
 *
 * @author andyc
 */
public class main_biblioteca {
     public static void main(String[] args) {
        libroDAO dao = new libroDAO();

        System.out.println("=== SISTEMA DE BIBLIOTECA ===");

        // Crear y agregar libros
        libro libro1 = new libro(0, "El Principito", "Antoine de Saint-Exupéry", 1943, "1234567890", true);
        dao.agregarLibro(libro1);

        // Listar todos
        System.out.println("--- Lista de libros ---");
        dao.listarLibros().forEach(System.out::println);

        // Buscar por autor
        System.out.println("--- Libros de 'Antoine' ---");
        dao.buscarPorAutor("Antoine").forEach(System.out::println);

        // Listar disponibles
        System.out.println("--- Libros disponibles ---");
        dao.listarDisponibles().forEach(System.out::println);

        // Actualizar libro
        libro1.setDisponible(false);
        dao.actualizarLibro(libro1);

        // Eliminar libro
        dao.eliminarLibro(1);
    }
}
