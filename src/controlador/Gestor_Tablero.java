package controlador;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class Gestor_Tablero {

    private static final int COLUMNAS = 5;  // Número de columnas del tablero
    private static final int FILAS = 10;    // Número de filas del tablero
    private GridPane tablero;
    private Circle[] jugadores;

    public Gestor_Tablero(GridPane tablero, Circle... jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;
    }

    // Mover un jugador
    public void moverJugador(int jugadorIndex, int pasos) {
        int posicionActual = (int) jugadores[jugadorIndex].getUserData();
        int nuevaPosicion = posicionActual + pasos;

        // Asegurarse de que no se pase del tablero
        if (nuevaPosicion >= COLUMNAS * FILAS) {
            nuevaPosicion = COLUMNAS * FILAS - 1;
        }

        // Calcula fila y columna
        int fila = nuevaPosicion / COLUMNAS;
        int columna = nuevaPosicion % COLUMNAS;

        // Actualiza la posición del jugador en el GridPane
        GridPane.setRowIndex(jugadores[jugadorIndex], fila);
        GridPane.setColumnIndex(jugadores[jugadorIndex], columna);

        // Actualiza la posición almacenada
        jugadores[jugadorIndex].setUserData(nuevaPosicion);
    }
}

