package cl.ucn.disc.pdbp.tdd.model;

import cl.ucn.disc.pdbp.utils.Validation;

public class Persona {
    private String nombre;
    private String apellido;
    private String rut;
    private String fijo;
    private String movil;
    private String direccion;
    private String email;

    public Persona(String nombre, String apellido, String rut, String fijo, String movil, String direccion, String email) {
        if (nombre == null || apellido == null || rut == null) {
            throw new NullPointerException("Nombre, apellido and rut cannot be null");
        }
        if (nombre.length() < 2) {
            throw new RuntimeException("Nombre must be greater than 2 characters");
        }
        this.nombre=nombre;
        if (apellido.length() < 3) {
            throw new RuntimeException("Apellido must be greater than 3 characters");
        }
        this.apellido=apellido;
        if (!Validation.isRutValid(rut)) {
            throw new RuntimeException("RUT should be valid");
        }
        this.rut=rut;
        if(!Validation.isPhoneValid(fijo)){
            throw new RuntimeException("Number should be valid");
        }
        this.fijo = fijo;
        if(!Validation.isPhoneValid(movil)){
            throw new RuntimeException("Phone number should be valid");
        }
        this.movil = movil;
        if(!Validation.isDireccionValid(movil)){
            throw new RuntimeException("Address should be valid");
        }
        this.direccion = direccion;
        if(!Validation.isEmailValid(movil)){
            throw new RuntimeException("Email should be valid");
        }
        this.email = email;
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
        return nombre+" "+apellido;
    }
}
