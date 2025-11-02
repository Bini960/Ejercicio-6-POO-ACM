/**
 * DispositivoAmbiental (abstracto)
 * Categoría para estaciones meteorológicas u otros equipos ambientales.
 */
public abstract class DispositivoAmbiental extends Dispositivo {
    public DispositivoAmbiental(String id, String nombre, String fabricante, double consumoWatts) {
        super(id, nombre, fabricante, consumoWatts);
    }
}
