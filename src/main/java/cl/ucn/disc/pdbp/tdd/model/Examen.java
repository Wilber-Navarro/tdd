package cl.ucn.disc.pdbp.tdd.model;

import java.time.ZonedDateTime;
/**
 * Examen Class
 * @autor Wilber Navarro
 */
public class Examen {
    private String nombre;
    /**
     * Date of control
     */
    private final ZonedDateTime fecha;

    /**
     * Constructor
     * @param nombre
     * @param fecha
     */
    public Examen(String nombre, ZonedDateTime fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public ZonedDateTime getFecha() {
        return fecha;
    }
}
