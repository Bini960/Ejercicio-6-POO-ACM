/**
 * Implementa Accionable y Registrable.
 * Acciones soportadas: "abrir", "cerrar"
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ValvulaRiego extends DispositivoCampo implements Accionable, Registrable {
    private List<String> log = new ArrayList<>();

    public ValvulaRiego(String id, String nombre, String fabricante, double consumoWatts) {
        super(id, nombre, fabricante, consumoWatts);
    }

    @Override
    public ResultadoAccion ejecutarAccion(String accion) {
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String accionLow = accion == null ? "" : accion.toLowerCase();
        boolean exito = accionLow.equals("abrir") || accionLow.equals("cerrar");
        String mensaje = exito ? "Acción ejecutada: " + accionLow : "Acción no soportada: " + accion;
        ResultadoAccion res = new ResultadoAccion(accion, exito, mensaje, ts);
        registrarEvento("Acción: " + res.toString());
        return res;
    }

    @Override
    public ResultadoAccion ejecutarAccion() {
        return ejecutarAccion("abrir");
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
        return super.toString().replace("Capacidades: ", "Capacidades: [Accionable] [Registrable]");
    }
}
