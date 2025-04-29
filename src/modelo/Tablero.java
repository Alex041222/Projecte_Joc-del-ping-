package modelo;

import java.util.ArrayList;

public class Tablero {
	
    private ArrayList<Casilla> casillas;
    private ArrayList<Jugador> jugadores;
    private int turno;
    private Jugador jugadorActual;

    // Constructor
    public Tablero() {
        this.casillas = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.turno = 0;
        this.jugadorActual = null;
    }

    // Getters
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

    // Setters
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

    // Método para actualizar el tablero al finalizar un turno
    public void actualizarTablero() {
        // Avanza el turno al siguiente jugador en forma circular
        turno = (turno + 1) % jugadores.size();
        jugadorActual = jugadores.get(turno);
    }

    // Método para ejecutar la acción de la casilla donde está el jugador
    public void ejecutarAccionJugador(Jugador jugador) {
        int posicion = jugador.getPosicion(); // Obtener la posición actual del jugador
        Casilla casillaActual = casillas.get(posicion); // Obtener la casilla correspondiente
        casillaActual.realizarAccion(jugador); // Ejecutar la acción de esa casilla
    }
}
