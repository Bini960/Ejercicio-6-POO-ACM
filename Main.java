/**
Andrés Castro Morales
25039
 * Punto de entrada. Inicializa SistemaOperativo, Vista y Controlador y arranca.
 */
public class Main {
    public static void main(String[] args) {
        SistemaOperativo sistema = new SistemaOperativo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(sistema, vista);

        controlador.iniciar();
    }
}
