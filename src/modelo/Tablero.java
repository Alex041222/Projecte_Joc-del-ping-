package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
        generarTablero();
    }

    public void generarTablero() {
        int totalCasillas = 50;
        Random rand = new Random();

        // Lista de posiciones para aleatorizar tipos especiales (evita la posición 0)
        ArrayList<Integer> posicionesDisponibles = new ArrayList<>();
        for (int i = 1; i < totalCasillas; i++) {
            posicionesDisponibles.add(i);
        }
        Collections.shuffle(posicionesDisponibles);

        // Añadir casillas normales por defecto
        for (int i = 0; i < totalCasillas; i++) {
            casillas.add(new Casilla(i));
        }

        // Reemplazar 1 casilla por CasillaOso
        int posOso = posicionesDisponibles.remove(0);
        casillas.set(posOso, new CasillaOso(posOso));
        
        // Reemplazar 4 casillas por CasillaHielo
        for (int i = 0; i < 4; i++) {
            int posHielo = posicionesDisponibles.remove(0);
            casillas.set(posHielo, new CasillaHielo(posHielo));
        }

        // Reemplazar 2 casillas por Trineo
        for (int i = 0; i < 2; i++) {
            int posTrineo = posicionesDisponibles.remove(0);
            casillas.set(posTrineo, new Trineo(posTrineo));  // No pasa la lista de jugadores
        }

        // Reemplazar 2 casillas por Agujero
        for (int i = 0; i < 2; i++) {
            int posAgujero = posicionesDisponibles.remove(0);
            casillas.set(posAgujero, new Agujero(posAgujero));  // No pasa la lista de jugadores
        }

        System.out.println("Tablero generado con 1 oso, 4 casillas de hielo, 2 trineos y 2 agujeros.");
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

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
        if (jugadores.size() == 1) {
            jugadorActual = jugador; // El primer jugador agregado es el primero en jugar
        }
        // Pasa la referencia del tablero a cada jugador
        for (Jugador j : jugadores) {
            j.setTablero(this);  // Asumimos que tienes un setter setTablero en la clase Jugador
        }
    }

    public void moverJugador(Jugador jugador, int avance) {
        int nuevaPos = jugador.getPosicion() + avance;

        if (nuevaPos >= casillas.size()) {
            nuevaPos = casillas.size() - 1; // No se sale del tablero
            System.out.println(jugador.getNombre() + " ha llegado al final del tablero!");
            // Aquí puedes implementar un mensaje de victoria o finalizar el juego
        }

        jugador.setPosicion(nuevaPos);
        Casilla casilla = casillas.get(nuevaPos);

        System.out.println(jugador.getNombre() + " cae en la casilla " + nuevaPos + " (" + casilla.getClass().getSimpleName() + ")");
        casilla.realizarAccion(jugador);
    }

    public void actualizarTurno() {
        turno = (turno + 1) % jugadores.size();
        jugadorActual = jugadores.get(turno);
    }

    public void ejecutarTurnoActual() {
        if (jugadorActual == null) return;

        // Imprimir "Turno de Pinguino1" solo al comienzo del turno y no más tarde.
        System.out.println("Turno de " + jugadorActual.getNombre());

        // Verifica si el jugador ya está en la última casilla
        if (jugadorActual.getPosicion() >= casillas.size() - 1) {
            System.out.println(jugadorActual.getNombre() + " ya está en la última casilla.");
            return; // Termina el turno si el jugador ya está en la última casilla
        }

        // Lanzar el dado y mover al jugador
        jugadorActual.tirarDado();
        moverJugador(jugadorActual, jugadorActual.getPosicion()); // Mover según dado lanzado
        
        // Ahora no es necesario llamar a actualizarTurno() en este punto.
        // El flujo continuará al siguiente turno sin reiniciar el ciclo por error.
    }
}