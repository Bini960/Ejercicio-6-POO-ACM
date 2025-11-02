//Implementa Medible y Registrable.

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EstacionMeteorologica extends DispositivoAmbiental implements Medible, Registrable {
    private List<String> log = new ArrayList<>();

    public EstacionMeteorologica(String id, String nombre, String fabricante, double consumoWatts) {
        super(id, nombre, fabricante, consumoWatts);
    }

    @Override
    public Medicion medir() {
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        double valor = Math.round((10 + Math.random() * 25) * 10.0) / 10.0; // temperatura hipotética
        Medicion m = new Medicion("Temperatura", valor, "°C", ts);
        registrarEvento("Medición: " + m.toString());
        return m;
    }

    @Override
    public void registrarEvento(String evento) {
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.add("[" + ts + "] " + evento);
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
