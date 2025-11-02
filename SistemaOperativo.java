/**
 * Mantiene la ÚNICA lista polimórfica catalogo: List<Dispositivo>.
 * Provee initCargaInicial() con 10 dispositivos, registrar, listar, buscar y ordenar.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaOperativo {
    private List<Dispositivo> catalogo = new ArrayList<>();

    public SistemaOperativo() {
        // constructor vacío
    }

    public void initCargaInicial() {
        // Al menos 10 elementos variados
        catalogo.add(new SensorSuelo("SS-01","Sensor Humedad","AgroTech",15.2));
        catalogo.add(new SensorSuelo("SS-02","Sensor Temperatura","AgroTech",16.0));
        catalogo.add(new EstacionMeteorologica("EM-01","Estación Clima","WeatherPro",35.5));
        catalogo.add(new EstacionMeteorologica("EM-02","Estación Viento","WeatherPro",32.0));
        catalogo.add(new ValvulaRiego("VR-01","Válvula 1","Irrimax",22.3));
        catalogo.add(new ValvulaRiego("VR-02","Válvula 2","Irrimax",20.0));
        catalogo.add(new CamaraMultiespectral("CM-01","Cámara NDVI","Optix",40.0));
        catalogo.add(new DroneRiego("DR-01","Drone Riego","FlyFarm",50.5));
        catalogo.add(new DroneMonitoreo("DM-01","Drone Monitoreo","SkyView",45.8));
        catalogo.add(new SensorSuelo("SS-03","Sensor pH","AgroTech",18.3));
    }

    public boolean registrar(Dispositivo d) {
        if (d == null) return false;
        for (Dispositivo existente : catalogo) {
            if (existente.getId().equalsIgnoreCase(d.getId())) return false; // id duplicado
        }
        catalogo.add(d);
        return true;
    }

    public List<Dispositivo> listar() {
        return new ArrayList<>(catalogo);
    }

    public Dispositivo buscarPorId(String id) {
        if (id == null) return null;
        for (Dispositivo d : catalogo) {
            if (d.getId().equalsIgnoreCase(id)) return d;
        }
        return null;
    }

    public List<Dispositivo> buscarPorNombre(String nombre) {
        List<Dispositivo> resultados = new ArrayList<>();
        if (nombre == null) return resultados;
        String q = nombre.toLowerCase();
        for (Dispositivo d : catalogo) {
            if (d.getNombre() != null && d.getNombre().toLowerCase().contains(q)) {
                resultados.add(d);
            }
        }
        return resultados;
    }

    public List<Dispositivo> ordenarPorConsumoAsc() {
        List<Dispositivo> copia = new ArrayList<>(catalogo);
        Collections.sort(copia); // usa compareTo en Dispositivo
        return copia;
    }

    public List<Dispositivo> getCatalogo() {
        return new ArrayList<>(catalogo);
    }

    public void setCatalogo(List<Dispositivo> catalogo) {
        this.catalogo = new ArrayList<>(catalogo);
    }
}
