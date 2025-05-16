package modelo;

import java.util.ArrayList;

public class Casilla {

    private int posicion;
    private ArrayList<Jugador> jugadoresActuales;

    public Casilla(int posicion) {
        this.posicion = posicion;
        this.jugadoresActuales = new ArrayList<>();
    }

    public int getPosicion() {
        return posicion;
    }
//actualizr pozicio
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
//llista jugadors
    public ArrayList<Jugador> getJugadoresActuales() {
        return jugadoresActuales;
    }
//posar jugadors
    public void setJugadoresActuales(ArrayList<Jugador> jugadoresActuales) {
        this.jugadoresActuales = jugadoresActuales;
    }

    // Implementación básica de acción
    public void realizarAccion(Jugador j) {
        System.out.println("El jugador " + j.getNombre() + " cae en una casilla normal.");
        j.tirarDado();
    }

    public void añadirJugador(Jugador j) {
        jugadoresActuales.add(j);
    }

    public void quitarJugador(Jugador j) {
        jugadoresActuales.remove(j);
    }
}