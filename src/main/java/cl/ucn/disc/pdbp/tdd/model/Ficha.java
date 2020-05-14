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

public class Ficha {
    private final int numeroFicha;
    private final String nombrePaciente;
    private final String especie;
    private final String fechaNacimiento;
    private final String raza;
    private final Sexo sexo;
    private final String color;
    private final Tipo tipo;

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
    public Ficha(int numeroFicha, String nombrePaciente, String especie, String fechaNacimiento, String raza, Sexo sexo, String color, Tipo tipo) {
        this.numeroFicha = numeroFicha;
        this.nombrePaciente = nombrePaciente;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.sexo = sexo;
        this.color = color;
        this.tipo = tipo;
    }

    /**
     *
     * @return numeroFicha.
     */
    public int getNumeroFicha() {
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
    public String getFechaNacimiento() {
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
}
