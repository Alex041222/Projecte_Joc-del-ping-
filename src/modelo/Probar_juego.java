package modelo;

import java.util.ArrayList;

public class Probar_juego {
    public static void main(String[] args) {
        // Crear el tablero y jugadores
        Tablero tablero = new Tablero();
        Jugador pinguino1 = new Jugador(0, "Pinguino1", "Azul");
        Jugador pinguino2 = new Jugador(0, "Pinguino2", "Rojo"); // ¡Posición debe iniciar en 0!

        // Crear e inicializar las casillas del tablero
        ArrayList<Casilla> casillas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {  // Creamos 50 casillas normales
            casillas.add(new Casilla(i));
        }
        tablero.setCasillas(casillas);

        // Agregar jugadores al tablero
        tablero.agregarJugador(pinguino1);
        tablero.agregarJugador(pinguino2);

        // Ejecutar turno del primer jugador
        tablero.actualizarTablero(); // Cambia al primer jugador
        tablero.ejecutarAccionJugador(tablero.getJugadorActual());

        // Ejecutar turno del segundo jugador
        tablero.actualizarTablero(); // Cambia al siguiente jugador
        tablero.ejecutarAccionJugador(tablero.getJugadorActual());
    }
}