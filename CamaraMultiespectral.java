//Implementa Medible y Registrable. Mide índice (ej. NDVI).

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CamaraMultiespectral extends DispositivoCampo implements Medible, Registrable {
    private List<String> log = new ArrayList<>();

    public CamaraMultiespectral(String id, String nombre, String fabricante, double consumoWatts) {
        super(id, nombre, fabricante, consumoWatts);
    }

    @Override
    public Medicion medir() {
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        double valor = Math.round((0.2 + Math.random() * 0.8) * 1000.0) / 1000.0; // NDVI entre 0.2-1.0
        Medicion m = new Medicion("NDVI", valor, "indice", ts);
        registrarEvento("Captura: " + m.toString());
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
