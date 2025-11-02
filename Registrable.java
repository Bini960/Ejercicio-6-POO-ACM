/**
 * Interfaz para dispositivos que guardan un log de eventos.
 * obtenerLog() retorna List<String>.
 */

import java.util.List;

public interface Registrable {
    void registrarEvento(String evento);
    List<String> obtenerLog();
}
