/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.clase.tienda;

/**
 *
 * @author andyc
 */
public class Producto {
     private int id;
    private String nombre;
    private double precio;
    private int stock;
    private int categoriaId;

    public Producto() {}

    public Producto(int id, String nombre, double precio, int stock, int categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoriaId = categoriaId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }

    @Override
    public String toString() {
        return id + " - " + nombre + " ($" + precio + ") stock: " + stock + " cat_id: " + categoriaId;
    }
}
