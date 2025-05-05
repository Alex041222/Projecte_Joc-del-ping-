package modelo;

import java.util.ArrayList;

public abstract class Casilla {
	
	private int posicion;
    private ArrayList<Jugador> jugadoresActuales;

    public Casilla(int posicion) {
        this.posicion = posicion;
        this.jugadoresActuales = new ArrayList<>();
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public ArrayList<Jugador> getJugadoresActuales() {
        return jugadoresActuales;
    }

    public void setJugadoresActuales(ArrayList<Jugador> jugadoresActuales) {
        this.jugadoresActuales = jugadoresActuales;
    }

    public abstract void realizarAccion(Jugador j);
    public abstract void añadirJugador(Jugador j);
    public abstract void quitarJugador(Jugador j);
}	