/**
 * Representa una lectura (tipo, valor, unidad, timestamp).
 * El timestamp es un String 
 */
public class Medicion {
    private String tipo;
    private double valor;
    private String unidad;
    private String timestamp;

    public Medicion(String tipo, double valor, String unidad, String timestamp) {
        this.tipo = tipo;
        this.valor = valor;
        this.unidad = unidad;
        this.timestamp = timestamp;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return tipo + ": " + valor + " " + unidad + " (" + timestamp + ")";
    }
}
