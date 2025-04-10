package modelo;

public class Oso {
	
	// Constructor
    public Oso() {
        System.out.println("Un oso ha aparecido en el tablero.");
    }

    // Si el oso ataca a un jugador ese jugador vuelve al inicio
    public void realizarAcción(Jugador jugador) {
        jugador.volverAlInicio();
        System.out.println(jugador.getNombre() + " has sido atacado por un oso y por lo tanto vuelves al inicio :(.");
    }
}
