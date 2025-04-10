package modelo;

import java.util.ArrayList;

public abstract class Casilla {
	
	private int Posicion;
	
	private ArrayList<Jugador>jugadoresActuales;

	public Casilla(int Posicion,ArrayList<Jugador> jugadoresActuales) {
		this.Posicion = Posicion;
		this.jugadoresActuales = new ArrayList<>();		
	}
	public int getPosicion() {
		return Posicion;
	}

	public void setPosicion(int posicion) {
		this.Posicion = posicion;
	}

	public ArrayList<Jugador> getJugadoresActuales() {
		return jugadoresActuales;
	}

	public void setJugadoresActuales(ArrayList<Jugador> jugadoresActuales) {
		this.jugadoresActuales = jugadoresActuales;
	}
	
	public abstract void realizarAccion();{
		
	}
	
	public abstract void añadirjugador(Jugador j);{
		
	}
	public abstract void quitarjugador(Jugador j);{
		
	}
	
}
 
	