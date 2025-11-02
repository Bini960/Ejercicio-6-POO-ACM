/**
 * Implementa Medible y Registrable.
 * Guarda su propio log (List<String>).
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SensorSuelo extends DispositivoCampo implements Medible, Registrable {
    private List<String> log = new ArrayList<>();

    public SensorSuelo(String id, String nombre, String fabricante, double consumoWatts) {
        super(id, nombre, fabricante, consumoWatts);
    }

    @Override
    public Medicion medir() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        double valor = Math.round((20 + Math.random() * 60) * 10.0) / 10.0; // ejemplo
        Medicion m = new Medicion("HumedadSuelo", valor, "%", timestamp);
        registrarEvento("Medición: " + m.toString());
        return m;
    }

    @Override
    public void registrarEvento(String evento) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.add("[" + timestamp + "] " + evento);
        // Limitar tamaño del log opcionalmente si se desea (no obligatorio)
    }

    @Override
    public List<String> obtenerLog() {
        return new ArrayList<>(log);
    }

    public List<String> getLog() { return new ArrayList<>(log); }
    public void setLog(List<String> log) { this.log = new ArrayList<>(log); }

    @Override
    public String toString() {
        return super.toString().replace("Capacidades: ", "Capacidades: [Medible] [Registrable]");
    }
}
