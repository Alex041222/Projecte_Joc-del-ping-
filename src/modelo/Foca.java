package modelo;

// La clase Foca hereda de Jugador
public class Foca extends Jugador {
	private boolean traidora; // Indica si la foca se volvió traidora (ya no juega limpio)
	    
	// Constructor: crea una nueva foca con nombre, color, posición y si es traidora
	public Foca(String Nombre, String Color, int Posicion, boolean traidora) {
	    super(Posicion, Color, Nombre); // Llama al constructor de Jugador (la clase padre)
	    this.traidora = traidora;
	}
	    
	// Devuelve si la foca es traidora
	public boolean getTraidora() {
	    return traidora;
	}
	    
	// Cambia el estado de "traidora"
	public void setTraidora(boolean traidora) {
	    this.traidora = traidora;
	}
	    
	// Acción: la foca aplasta a un pingüino
	public void aplastarJugador(Pingüino p) {
	    // Muestra un mensaje diciendo que aplastó al pingüino
	    System.out.println("La foca aplasta al pingüino " + p.getNombre());
	}
	    
	// Acción: la foca golpea a un pingüino
	public void golpearJugador(Pingüino p) {
		
	    // Muestra un mensaje diciendo que golpeó al pingüino
	    System.out.println("La foca golpea al pingüino " + p.getNombre());
	}
}