/**
Andrés Castro Morales
25039
 * - Contiene TODOS los System.out.println del programa.
 * - Genera el menú, lee la opción y produce las salidas legibles para el usuario.
 * - No realiza lógica del negocio; solo formatea y muestra datos.
 */

import java.util.List;
import java.util.Scanner;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarEncabezado() {
        System.out.println("=== Sistema Cooperativa Agro-Tec ===");
        System.out.println("Gestión de dispositivos - Ejercicio 6 (Interfaces)");
        System.out.println();
    }

    public void mostrarMenuPrincipal() {
        System.out.println("Menú principal:");
        System.out.println("1 - Listar todos los equipos");
        System.out.println("2 - Buscar equipo por ID");
        System.out.println("3 - Buscar equipo por nombre");
        System.out.println("4 - Ordenar catálogo por consumo (asc)");
        System.out.println("5 - Ver log de un dispositivo (por ID)");
        System.out.println("6 - Salir");
        System.out.print("Seleccione una opción (1-6): ");
    }

    public int leerOpcion() {
        String linea = scanner.nextLine();
        try {
            return Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String solicitarId() {
        System.out.print("Ingrese ID del dispositivo: ");
        return scanner.nextLine().trim();
    }

    public String solicitarNombre() {
        System.out.print("Ingrese nombre (o parte) a buscar: ");
        return scanner.nextLine().trim();
    }

    public void mostrarListado(List<Dispositivo> items) {
        System.out.println("--- Listado de equipos ---");
        if (items == null || items.isEmpty()) {
            System.out.println("[Vacío]");
            return;
        }
        for (Dispositivo d : items) {
            System.out.println(formatoDispositivoResumen(d));
        }
    }

    public void mostrarDispositivo(Dispositivo d) {
        System.out.println("--- Detalle del dispositivo ---");
        if (d == null) {
            System.out.println("Dispositivo no encontrado.");
            return;
        }
        // Mostrar atributos principales
        System.out.println("ID: " + d.getId());
        System.out.println("Nombre: " + d.getNombre());
        System.out.println("Fabricante: " + d.getFabricante());
        System.out.println("Consumo (W): " + d.getConsumoWatts());
        System.out.println("Activo: " + d.isActivo());

        // Mostrar capacidades detectadas (según interfaces)
        String caps = "";
        if (d instanceof Medible) caps += "[Medible] ";
        if (d instanceof Accionable) caps += "[Accionable] ";
        if (d instanceof Registrable) caps += "[Registrable] ";
        System.out.println("Capacidades: " + caps);

        // Si es Medible, mostrar una medición de ejemplo (OPCIONAL: no obligatorio)
        if (d instanceof Medible) {
            Medicion m = ((Medible) d).medir();
            System.out.println("Última medición (ejemplo): " + m);
        }
    }

    public void mostrarBusquedaNombre(String nombre, List<Dispositivo> res) {
        System.out.println("--- Resultados para: \"" + nombre + "\" ---");
        if (res == null || res.isEmpty()) {
            System.out.println("No se encontraron dispositivos.");
            return;
        }
        for (Dispositivo d : res) {
            System.out.println(formatoDispositivoResumen(d));
        }
    }

    public void mostrarOrdenadoPorConsumo(List<Dispositivo> res) {
        System.out.println("--- Catálogo ordenado por consumo (asc) ---");
        if (res == null || res.isEmpty()) {
            System.out.println("[Vacío]");
            return;
        }
        for (Dispositivo d : res) {
            System.out.println(formatoDispositivoResumen(d));
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarLog(List<String> log) {
        System.out.println("--- Log del dispositivo ---");
        if (log == null || log.isEmpty()) {
            System.out.println("[Sin eventos]");
            return;
        }
        for (String s : log) {
            System.out.println(s);
        }
    }

    public void mostrarSeparador() {
        System.out.println();
    }

    private String formatoDispositivoResumen(Dispositivo d) {
        String caps = "";
        if (d instanceof Medible) caps += "[Medible] ";
        if (d instanceof Accionable) caps += "[Accionable] ";
        if (d instanceof Registrable) caps += "[Registrable] ";
        return String.format("%s | %s | %s | Consumo: %.1f W | %s",
                d.getId(), d.getNombre(), d.getFabricante(), d.getConsumoWatts(), caps);
    }
}
