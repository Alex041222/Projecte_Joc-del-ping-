package modelo;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;
    private ArrayList<Jugador> jugadores;
    private int turno;
    private Jugador jugadorActual;

    public Tablero() {
        this.casillas = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.turno = 0;
        this.jugadorActual = null;
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public int getTurno() {
        return turno;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public void actualizarTablero() {
        turno = (turno + 1) % jugadores.size();
        jugadorActual = jugadores.get(turno);
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void ejecutarAccionJugador(Jugador jugador) {
        int posicion = jugador.getPosicion();
        Casilla casillaActual = casillas.get(posicion);
        casillaActual.realizarAccion(jugador);
    }
}