/**
 * Drone (abstracto)
 * Base para drones de riego y monitoreo.
 */
public abstract class Drone extends DispositivoCampo {
    public Drone(String id, String nombre, String fabricante, double consumoWatts) {
        super(id, nombre, fabricante, consumoWatts);
    }
}
