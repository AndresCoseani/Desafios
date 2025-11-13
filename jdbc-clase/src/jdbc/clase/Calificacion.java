package jdbc.clase;

import java.sql.Date;

public class Calificacion {
    private int id;
    private int estudianteId;
    private String materia;
    private double nota;
    private Date fecha;

    public Calificacion() {}

    public Calificacion(int estudianteId, String materia, double nota, Date fecha) {
        this.estudianteId = estudianteId;
        this.materia = materia;
        this.nota = nota;
        this.fecha = fecha;
    }

    public Calificacion(int id, int estudianteId, String materia, double nota, Date fecha) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.materia = materia;
        this.nota = nota;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEstudianteId() { return estudianteId; }
    public void setEstudianteId(int estudianteId) { this.estudianteId = estudianteId; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return String.format("Calificación[ID=%d, EstudianteID=%d, Materia=%s, Nota=%.2f, Fecha=%s]",
                id, estudianteId, materia, nota, fecha);
    }
}
