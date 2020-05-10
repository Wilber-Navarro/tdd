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

    public int getNumeroFicha() {
        return numeroFicha;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getEspecie() {
        return especie;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getRaza() {
        return raza;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getColor() {
        return color;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
