/*
 * MIT License
 *
 * Copyright (c) [2020.] [Wilber Mauricio Navarro Moreira]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cl.ucn.disc.pdbp.tdd.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cl.ucn.disc.pdbp.utils.Validation;

/**
 * Persona Class.
 * @autor Wilber Navarro.
 */
@DatabaseTable(tableName = "persona")
public class Persona {

    /**
     * The id:Primary key and autoincrement.
     */
    @DatabaseField(generatedId = true)
    private Long id;

    /**
     * The nombre
     */
    @DatabaseField(canBeNull = false)
    private String nombre;

    /**
     * The apellido
     */
    @DatabaseField(canBeNull = false)
    private String apellido;

    /**
     * The rut
     */
    @DatabaseField(canBeNull = false, index = true,unique = true)
    private String rut;

    /**
     * The numero fijo
     */
    @DatabaseField
    private String fijo;

    /**
     * The numero movil
     */
    @DatabaseField
    private String movil;

    /**
     * The direccion
     */
    @DatabaseField
    private String direccion;

    /**
     * The email
     */
    @DatabaseField(canBeNull = false,unique = true)
    private String email;

    /**
     * The Constructor.
     */
    public Persona(String nombre, String apellido, String rut, String email) {
        this(rut, nombre, apellido, null, null, null, email);
    }
    /**
     * Constructor
     * @param nombre de la persona.
     * @param apellido de la persona.
     * @param rut de la persona.
     * @param fijo numero fijo de la persona.
     * @param movil numero movil de la persona.
     * @param direccion de la persona.
     * @param email de la persona.
     */
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
        if(!Validation.isDireccionValid(direccion)){
            throw new RuntimeException("Address should be valid");
        }
        this.direccion = direccion;
        if(!Validation.isEmailValid(email)){
            throw new RuntimeException("Email should be valid");
        }
        this.email = email;
    }

    /**
     * Empy Constructor
      */
    Persona(){
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
     * @return apellido.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @return rut.
     */
    public String getRut() {
        return rut;
    }

    /**
     *
     * @return Nombre Apellido.
     */
    public String getNombreApellido() {
        return nombre+" "+apellido;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }
}
