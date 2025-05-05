package controlador;

import java.util.ArrayList;
import java.util.List;

public class Gestor_Partidas {
    // Datos de las partidas (simulando una "base de datos")
    private List<String> partidas = new ArrayList<>(); // Ejemplo: guarda nombres de partidas

    // Singleton (para acceder desde FXML)
    private static Gestor_Partidas instancia;
    public static Gestor_Partidas getInstancia() {
        if (instancia == null) {
            instancia = new Gestor_Partidas();
        }
        return instancia;
    }

    // Métodos básicos
    public void agregarPartida(String nombrePartida) {
        if (nombrePartida != null && !nombrePartida.trim().isEmpty()) {
            partidas.add(nombrePartida);
        }
    }

    public List<String> getPartidas() {
        return new ArrayList<>(partidas); // Copia para evitar modificaciones externas
    }

    public void eliminarPartida(String nombrePartida) {
        partidas.remove(nombrePartida);
    }
}