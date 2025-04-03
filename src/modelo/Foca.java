package modelo;

public class Foca extends Jugador {
	private boolean soborno;
	    
	public Foca(String Nombre, String Color, int Posicion, boolean soborno) {
	    super(Nombre, Color, Posicion); // Llamada al constructor de Jugador
	    this.soborno = soborno;
	}
	    
	public boolean getSoborno() {
	    return soborno;
	}
	    
	public void setSoborno(boolean soborno) {
	    this.soborno = soborno;
	}
	    
	public void aplastarJugador(Pinguino p) {
	    // Implementa la lógica para aplastar a un pingüino
	    System.out.println("La foca aplasta al pingüino " + p.getNombre());
	}
	    
	public void golpearJugador(Pinguino p) {
	    // Implementa la lógica para golpear a un pingüino
	    System.out.println("La foca golpea al pingüino " + p.getNombre());
	}
}
