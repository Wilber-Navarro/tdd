package cl.ucn.disc.pdbp.tdd.model;

import java.time.ZonedDateTime;

/**
 * Examen Class.
 * @autor Wilber Navarro.
 */
public class Examen {

    /**
     *
     */
    private String nombre;

    /**
     * Date of control.
     */
    private final ZonedDateTime fecha;

    /**
     * Constructor.
     * @param nombre del examen.
     * @param fecha en la que fue tomado el examen.
     */
    public Examen(String nombre, ZonedDateTime fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    /**
     *
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return fecha.
     */
    public ZonedDateTime getFecha() {
        return fecha;
    }
}
