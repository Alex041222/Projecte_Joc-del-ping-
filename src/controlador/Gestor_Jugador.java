package controlador;


import java.util.ArrayList;
import java.util.List;

public class Gestor_Jugador {
	   // Llista de jugadors
    private final List<Jugador> jugadors = new ArrayList<>();

    // Classe interna per a Jugador 
    public static class Jugador {
        public final String nom;
        public int puntuacio;
        
        public Jugador(String nom, int puntuacio) {
            this.nom = nom;
            this.puntuacio = puntuacio;
        }
    }

    // Singleton
    private static Gestor_Jugador instancia;
    public static Gestor_Jugador getInstancia() {
        if (instancia == null) {
            instancia = new Gestor_Jugador();
        }
        return instancia;
    }

    // Afegir jugador
    public void afegirJugador(String nom, int puntuacio) {
        jugadors.add(new Jugador(nom, puntuacio));
    }

    // Obtenir llista de jugadors 
    public List<Jugador> getJugadors() {
        return new ArrayList<>(jugadors);
    }

    // Eliminar jugador 
    public void eliminarJugador(String nom) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < jugadors.size()) {
            if (jugadors.get(i).nom.equals(nom)) {
                jugadors.remove(i);
                trobat = true;
            }
            i++;
        }
    }
}