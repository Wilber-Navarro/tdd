package cl.ucn.disc.pdbp.tdd.model;
import java.time.ZonedDateTime;
public class Control {
    private final ZonedDateTime fechaControl;
    private final ZonedDateTime fechaProxControl;
    private final Float temperatura;
    private final Float peso;
    private final Float altura;
    private final String diagnostico;
    private Persona veterinatio;

    public Control(ZonedDateTime fechaControl, ZonedDateTime fechaProxControl, Float temperatura, Float peso, Float altura, String diagnostico, Persona veterinatio) {
        this.fechaControl = fechaControl;
        this.fechaProxControl = fechaProxControl;
        this.temperatura = temperatura;
        this.peso = peso;
        this.altura = altura;
        this.diagnostico = diagnostico;
        this.veterinatio = veterinatio;
    }

    public ZonedDateTime getFechaControl() {
        return fechaControl;
    }

    public ZonedDateTime getFechaProxControl() {
        return fechaProxControl;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public Float getPeso() {
        return peso;
    }

    public Float getAltura() {
        return altura;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public Persona getVeterinatio() {
        return veterinatio;
    }
}
