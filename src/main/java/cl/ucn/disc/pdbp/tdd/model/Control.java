package cl.ucn.disc.pdbp.tdd.model;
import java.time.ZonedDateTime;

/**
 * Control Class
 * @autor Wilber Navarro.
 */
public class Control {

    /**
     * Date of control.
     */
    private final ZonedDateTime fechaControl;

    /**
     * Date of next control.
     */
    private final ZonedDateTime fechaProxControl;

    /**
     * Temperatura.
     */
    private final Float temperatura;

    /**
     * Peso.
     */
    private final Float peso;

    /**
     * Altura.
     */
    private final Float altura;

    /**
     * Diagnostico.
     */
    private final String diagnostico;

    /**
     * Veterinario.
     */
    private Persona veterinatio;

    /**
     * Constructor.
     * @param fechaControl  fecha del control.
     * @param fechaProxControl fecha del proximo control.
     * @param temperatura del paciente en grados celsius.
     * @param peso del paciente.
     * @param altura del paciente.
     * @param diagnostico textual del control.
     * @param veterinatio nombre del veterinario.
     */
    public Control(ZonedDateTime fechaControl, ZonedDateTime fechaProxControl, Float temperatura, Float peso, Float altura, String diagnostico, Persona veterinatio) {
        this.fechaControl = fechaControl;
        this.fechaProxControl = fechaProxControl;
        this.temperatura = temperatura;
        this.peso = peso;
        this.altura = altura;
        this.diagnostico = diagnostico;
        this.veterinatio = veterinatio;
    }

    /**
     *
     * @return fechaControl.
     */
    public ZonedDateTime getFechaControl() {
        return fechaControl;
    }

    /**
     *
     * @return fechaProxControl.
     */
    public ZonedDateTime getFechaProxControl() {
        return fechaProxControl;
    }

    /**
     *
     * @return temperatura.
     */
    public Float getTemperatura() {
        return temperatura;
    }

    /**
     *
     * @return peso.
     */
    public Float getPeso() {
        return peso;
    }

    /**
     *
     * @return altura.
     */
    public Float getAltura() {
        return altura;
    }
    /**
     *
     * @return diagnostico.
     */
    public String getDiagnostico() {
        return diagnostico;
    }
    /**
     *
     * @return Veterinario.
     */
    public Persona getVeterinatio() {
        return veterinatio;
    }

}
