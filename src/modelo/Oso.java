package modelo;

public class Oso {
	
	// Constructor: se ejecuta cuando se crea un oso
    public Oso() {
        // Muestra un mensaje avisando que apareció un oso
        System.out.println("Un oso ha aparecido en el tablero.");
    }

    // El oso ataca a un jugador y lo manda al inicio del juego
    public void realizarAcción(Jugador jugador) {
        jugador.volverAlInicio(); // El jugador regresa a la casilla de inicio
        System.out.println(jugador.getNombre() + " ha sido atacado por un oso y por lo tanto vuelve al inicio :(.");
    }
}