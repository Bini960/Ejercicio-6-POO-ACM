/**
 * Orquesta la interacción entre Vista y SistemaOperativo.
 * El ciclo principal está en iniciar() y NO usa while(true) con break.
 * Todas las impresiones permanecen en Vista.
 */

import java.util.List;

public class Controlador {
    private SistemaOperativo sistema;
    private Vista vista;

    public Controlador(SistemaOperativo sistema, Vista vista) {
        this.sistema = sistema;
        this.vista = vista;
    }

    public void iniciar() {
        // Inicializar datos
        sistema.initCargaInicial();

        // Mostrar encabezado y menú hasta que el usuario elija salir
        vista.mostrarEncabezado();

        int opcion = -1;
        while (opcion != 6) {
            vista.mostrarMenuPrincipal();
            opcion = vista.leerOpcion();
            switch (opcion) {
                case 1:
                    opcionListar();
                    break;
                case 2:
                    opcionBuscarPorId();
                    break;
                case 3:
                    opcionBuscarPorNombre();
                    break;
                case 4:
                    opcionOrdenarPorConsumo();
                    break;
                case 5:
                    opcionVerLog();
                    break;
                case 6:
                    vista.mostrarMensaje("Saliendo. ¡Hasta luego!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
            // separación visual trasladada a Vista para mantener prints en un solo lugar
            vista.mostrarSeparador();
        }
    }

    public void opcionListar() {
        List<Dispositivo> todos = sistema.listar();
        vista.mostrarListado(todos);
    }

    public void opcionBuscarPorId() {
        String id = vista.solicitarId();
        Dispositivo d = sistema.buscarPorId(id);
        vista.mostrarDispositivo(d);
    }

    public void opcionBuscarPorNombre() {
        String nombre = vista.solicitarNombre();
        List<Dispositivo> res = sistema.buscarPorNombre(nombre);
        vista.mostrarBusquedaNombre(nombre, res);
    }

    public void opcionOrdenarPorConsumo() {
        List<Dispositivo> ordenado = sistema.ordenarPorConsumoAsc();
        vista.mostrarOrdenadoPorConsumo(ordenado);
    }

    public void opcionVerLog() {
        String id = vista.solicitarId();
        Dispositivo d = sistema.buscarPorId(id);
        if (d == null) {
            vista.mostrarMensaje("Dispositivo no encontrado.");
            return;
        }
        if (d instanceof Registrable) {
            List<String> log = ((Registrable) d).obtenerLog();
            vista.mostrarLog(log);
        } else {
            vista.mostrarMensaje("El dispositivo no implementa registro (Registrable).");
        }
    }

    // Getters/Setters 
    public SistemaOperativo getSistema() { return sistema; }
    public void setSistema(SistemaOperativo sistema) { this.sistema = sistema; }
    public Vista getVista() { return vista; }
    public void setVista(Vista vista) { this.vista = vista; }
}
