package vista;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import modelo.Tablero;
import modelo.Casilla; // Asegúrate de tener este import según tu estructura de paquetes

public class Pantalla_JuegoController {

    // Menu items
    @FXML private MenuItem newGame;
    @FXML private MenuItem saveGame;
    @FXML private MenuItem loadGame;
    @FXML private MenuItem quitGame;

    // Buttons
    @FXML private Button dado;
    @FXML private Button rapido;
    @FXML private Button lento;
    @FXML private Button peces;
    @FXML private Button nieve;

    // Texts
    @FXML private Text dadoResultText;
    @FXML private Text rapido_t;
    @FXML private Text lento_t;
    @FXML private Text peces_t;
    @FXML private Text nieve_t;
    @FXML private Text eventos;

    // Game board and player piece
    @FXML private GridPane tablero;
    @FXML private Circle P1;  
    @FXML private Circle P2;
    @FXML private Circle P3;
    @FXML private Circle P4;
    @FXML private Circle P5;
    
    // Position tracking
    private int p1Position = 0; // Tracks current position (from 0 to 49 in a 5x10 grid)
    private final int COLUMNS = 5;

    @FXML
    private void initialize() {
        eventos.setText("¡El juego ha comenzado!");

        // Instanciamos un nuevo tablero
        Tablero tableroJuego = new Tablero();

        // Mostramos los nombres de las casillas
        mostrarTiposDeCasillasEnTablero(tableroJuego);
    }

    @FXML
    private void handleNewGame() {
        System.out.println("New game.");
        // Aquí deberías crear un nuevo tablero y mostrarlo
        // Tablero nuevoTablero = new Tablero();
        // mostrarTiposDeCasillasEnTablero(nuevoTablero);
    }

    @FXML
    private void handleSaveGame() {
        System.out.println("Saved game.");
    }

    @FXML
    private void handleLoadGame() {
        System.out.println("Loaded game.");
        // Tablero cargado = ...;
        // mostrarTiposDeCasillasEnTablero(cargado);
    }

    @FXML
    private void handleQuitGame() {
        System.out.println("Exit...");
    }

    @FXML
    private void handleDado(ActionEvent event) {
        Random rand = new Random();
        int diceResult = rand.nextInt(6) + 1;
        dadoResultText.setText("Ha salido: " + diceResult);
        moveP1(diceResult);
    }

    private void moveP1(int steps) {
        p1Position += steps;
        if (p1Position >= 50) {
            p1Position = 49;
            eventos.setText("¡Has llegado al final del tablero!");
        }

        int row = p1Position / COLUMNS;
        int col = p1Position % COLUMNS;

        GridPane.setRowIndex(P1, row);
        GridPane.setColumnIndex(P1, col);
    }

    @FXML
    private void handleRapido() {
        System.out.println("Fast.");
    }

    @FXML
    private void handleLento() {
        System.out.println("Slow.");
    }

    @FXML
    private void handlePeces() {
        System.out.println("Fish.");
    }

    @FXML
    private void handleNieve() {
        System.out.println("Snow.");
    }

    private void mostrarTiposDeCasillasEnTablero(Tablero t) {
        tablero.getChildren().removeIf(node -> node instanceof Text);

        for (int i = 0; i < t.getCasillas().size(); i++) {
            Casilla casilla = t.getCasillas().get(i);

            if (i == 0 || i == 49) continue;

            String tipo = casilla.getClass().getSimpleName();

            Text texto = new Text(tipo);
            texto.setStyle("-fx-font-size: 14px; -fx-fill: black; -fx-font-weight: bold;");

            int row = i / COLUMNS;
            int col = i % COLUMNS;

            GridPane.setRowIndex(texto, row);
            GridPane.setColumnIndex(texto, col);

            tablero.getChildren().add(texto);
        }
    }
}