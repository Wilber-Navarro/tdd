package cl.ucn.disc.pdbp.tdd.model;

public class Persona {
    private final String nombre;
    private final String apellido;
    private final String rut;

    public Persona(String nombre, String apellido, String rut) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.rut=rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }

    public String getNombreApellido() {
        return apellido;
    }
}
