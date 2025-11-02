/**
 * Atributos comunes a todos los dispositivos y Comparable por consumoWatts.
 * equals/hashCode basados en id.
 */

import java.util.Objects;

public abstract class Dispositivo implements Comparable<Dispositivo> {
    private String id;
    private String nombre;
    private String fabricante;
    private double consumoWatts;
    private boolean activo;

    public Dispositivo(String id, String nombre, String fabricante, double consumoWatts) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.consumoWatts = consumoWatts;
        this.activo = false;
    }

    public void encender() { this.activo = true; }
    public void apagar() { this.activo = false; }
    public boolean isActivo() { return activo; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public double getConsumoWatts() { return consumoWatts; }
    public void setConsumoWatts(double consumoWatts) { this.consumoWatts = consumoWatts; }

    @Override
    public int compareTo(Dispositivo o) {
        return Double.compare(this.consumoWatts, o.consumoWatts);
    }

    @Override
    public String toString() {
        String capacidades = "";
        return "[" + id + "] " + nombre + " | " + fabricante +
               " | Consumo: " + consumoWatts + " W | Activo: " + activo +
               " | Capacidades: " + capacidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispositivo)) return false;
        Dispositivo that = (Dispositivo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
