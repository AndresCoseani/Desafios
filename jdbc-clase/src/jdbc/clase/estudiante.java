package jdbc.clase;


public class estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    
    // Constructor vacío
    public estudiante() {}
    
    // Constructor completo
    public estudiante(int id, String nombre, String apellido, String email, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }
    
    // Constructor sin ID (para inserciones nuevas)
    public estudiante(String nombre, String apellido, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    @Override
    public String toString() {
        return String.format("Estudiante[ID=%d, Nombre=%s %s, Email=%s, Edad=%d]",
                id, nombre, apellido, email, edad);
    }
}
