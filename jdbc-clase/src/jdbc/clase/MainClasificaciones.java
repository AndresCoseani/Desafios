/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.clase;

import java.sql.Date;
import java.time.LocalDate;

public class MainClasificaciones {
    public static void main(String[] args) {

        CalificacionDAO dao = new CalificacionDAO();

        System.out.println("=== SISTEMA DE NOTAS ESTUDIANTILES ===\n");

        // 1. Insertar calificaciones
        System.out.println("--- Insertando calificaciones ---");
        dao.insertar(new Calificacion(1, "Matemática", 8.5, Date.valueOf(LocalDate.now())));
        dao.insertar(new Calificacion(1, "Lengua", 9.0, Date.valueOf(LocalDate.now())));
        dao.insertar(new Calificacion(2, "Inglés", 7.5, Date.valueOf(LocalDate.now())));
        dao.insertar(new Calificacion(2, "Historia", 8.0, Date.valueOf(LocalDate.now())));

        // 2. Listar historial de un estudiante
        System.out.println("\n--- Historial del estudiante ID 1 ---");
        dao.obtenerPorEstudiante(1).forEach(System.out::println);

        // 3. Calcular promedio
        double promedio = dao.calcularPromedio(1);
        System.out.printf("\nPromedio del estudiante 1: %.2f%n", promedio);

        // 4. Mostrar todo con JOIN
        System.out.println();
        dao.listarConEstudiante();
    }
}