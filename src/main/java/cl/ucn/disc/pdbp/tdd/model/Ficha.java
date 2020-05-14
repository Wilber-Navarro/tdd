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
