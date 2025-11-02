/**
 * Interfaz para dispositivos que pueden ejecutar acciones.
 * Overloading: ejecutarAccion() y ejecutarAccion(String).
 */
public interface Accionable {
    ResultadoAccion ejecutarAccion(String accion);
    ResultadoAccion ejecutarAccion();
}