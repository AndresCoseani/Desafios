/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.clase.tienda;

/**
 *
 * @author andyc
 */
public class main_tienda {
     public static void main(String[] args) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ProductoDAO productoDAO = new ProductoDAO();

        System.out.println("=== SISTEMA DE TIENDA ===");

        // Agregar categorías
        categoriaDAO.agregarCategoria(new Categoria(0, "Electrónica"));
        categoriaDAO.agregarCategoria(new Categoria(0, "Libros"));

        // Listar categorías
        System.out.println("--- Categorías ---");
        categoriaDAO.listarCategorias().forEach(System.out::println);

        // Agregar productos
        productoDAO.agregarProducto(new Producto(0, "Notebook HP", 750000, 10, 1));
        productoDAO.agregarProducto(new Producto(0, "El Principito", 5000, 25, 2));

        // Listar productos con JOIN
        productoDAO.listarProductosConCategoria();
    }
}
