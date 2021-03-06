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

import cl.ucn.disc.pdbp.tdd.dao.ZonedDateTimeType;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Ficha veterinaria.
 *
 * @author Wilber Navarro.
 */
public class Ficha {

    /**
     * Id.
     */
    @DatabaseField(generatedId = true)
    private Long id;

    /**
     * Numero de ficha.
     */
    @DatabaseField(canBeNull = false, unique = true)
    private Integer numeroFicha;
    /**
     * Nombre del paciente.
     */
    @DatabaseField
    private String nombrePaciente;

    /**
     * Especie del paciente.
     */
    @DatabaseField
    private String especie;

    /**
     * Fecha de nacimiento de paciente.
     */
    @DatabaseField(persisterClass = ZonedDateTimeType.class)
    private ZonedDateTime fechaNacimiento;

    /**
     * Raza del paciente.
     */
    @DatabaseField
    private String raza;

    /**
     * Sexo del paciente.
     */
    @DatabaseField
    private Sexo sexo;

    /**
     * color del paciente.
     */
    @DatabaseField
    private String color;

    /**
     * Tipo.
     */
    @DatabaseField
    private Tipo tipo;

    /**
     * The duenio.
     */
    @DatabaseField(foreign=true, canBeNull = false, foreignAutoRefresh = true)
    private Persona duenio;

    /**
     * The list of Control.
     */
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Control> controles;


    /**
     *
     * @param numeroFicha correlativo numerico unico.
     * @param nombrePaciente nombre del paciente.
     * @param especie del paciente.
     * @param fechaNacimiento del paciente.
     * @param raza del paciente.
     * @param sexo del paciente.
     * @param color del paciente.
     * @param tipo del paciente.
     */
    public Ficha(Integer numeroFicha,
                 String nombrePaciente,
                 String especie,
                 ZonedDateTime fechaNacimiento,
                 String raza, Sexo sexo,
                 String color,
                 Tipo tipo,
                 Persona duenio) {

        this.numeroFicha = numeroFicha;
        this.nombrePaciente = nombrePaciente;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.sexo = sexo;
        this.color = color;
        this.tipo = tipo;
        this.duenio=duenio;
    }

    /**
     * Empty constructor.
     */
    Ficha(){
       //Nothing
    }

    /**
     *
     * @return numeroFicha.
     */
    public Integer getNumeroFicha() {
        return numeroFicha;
    }

    /**
     *
     * @return nombrepaciente.
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     *
     * @return especie.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     *
     * @return fechaNacimiento.
     */
    public ZonedDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @return raza.
     */
    public String getRaza() {
        return raza;
    }

    /**
     *
     * @return sexo.
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     *
     * @return color.
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @return tipo.
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     *
     * @return id.
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @return duenio.
     */
    public Persona getDuenio() {
        return duenio;
    }

    /**
     *
     * @return List of Controles.
     */
    public List<Control> getControles() {
        return Collections.unmodifiableList(new ArrayList<>(controles));
    }
}
