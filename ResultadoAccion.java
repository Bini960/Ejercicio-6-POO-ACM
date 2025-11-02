//Representa el resultado de ejecutar una acción sobre un dispositivo.

public class ResultadoAccion {
    private String accion;
    private boolean exito;
    private String mensaje;
    private String timestamp;

    public ResultadoAccion(String accion, boolean exito, String mensaje, String timestamp) {
        this.accion = accion;
        this.exito = exito;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public boolean isExito() { return exito; }
    public void setExito(boolean exito) { this.exito = exito; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + accion + " -> " + mensaje + " (exito=" + exito + ")";
    }
}
