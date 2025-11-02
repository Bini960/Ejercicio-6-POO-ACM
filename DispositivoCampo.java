/**
 * DispositivoCampo (abstracto)
 * Categoría para sensores/actuadores en el campo.
 */
public abstract class DispositivoCampo extends Dispositivo {
    public DispositivoCampo(String id, String nombre, String fabricante, double consumoWatts) {
        super(id, nombre, fabricante, consumoWatts);
    }
}
