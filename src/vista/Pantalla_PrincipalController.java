package vista;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;

import modelo.JugadorDAO;  // ← Importa el DAO

public class Pantalla_PrincipalController {

    // Ajusta aquí tus datos de conexión:
    private static final boolean CENTRO     = true;      // true = URL_CENTRO, false = URL_FUERA
    private static final String  USUARIO_BD = "YASMINA";
    private static final String  PWD_BD     = "0000";

    @FXML private MenuItem    newGame, saveGame, loadGame, quitGame;
    @FXML private TextField   userField;
    @FXML private PasswordField passField;
    @FXML private Button      loginButton, registerButton;

    @FXML
    private void initialize() {
        System.out.println("pantallaPrincipalController initialized");
    }

    @FXML
    private void handleRegister(ActionEvent event) {
        String nombre = userField.getText().trim();
        String pwd    = passField.getText().trim();
        if (nombre.isEmpty() || pwd.isEmpty()) {
            System.out.println("Debes rellenar usuario y contraseña.");
            return;
        }

        int idJugador = new Random().nextInt(1_000_000);
        // Llamada al DAO para INSERT
        JugadorDAO.insertar(
            idJugador,
            nombre,
            pwd,
            CENTRO,
            USUARIO_BD,
            PWD_BD
        );
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String nombre = userField.getText().trim();
        String pwd    = passField.getText().trim();
        if (nombre.isEmpty() || pwd.isEmpty()) {
            System.out.println("Debes rellenar usuario y contraseña.");
            return;
        }

        // Llamada al DAO para SELECT de login
        boolean ok = JugadorDAO.login(
            nombre,
            pwd,
            CENTRO,
            USUARIO_BD,
            PWD_BD
        );

        if (ok) {
            System.out.println("Login exitoso: " + nombre);
            try {
                FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/pantallaJuego.fxml")
                );
                Parent root = loader.load();
                Stage stage = (Stage)((Node)event.getSource())
                                   .getScene()
                                   .getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Pantalla de Juego");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    @FXML private void handleNewGame()  { System.out.println("Nuevo juego"); }
    @FXML private void handleSaveGame() { System.out.println("Guardar juego"); }
    @FXML private void handleLoadGame() { System.out.println("Cargar juego"); }
    @FXML private void handleQuitGame() { System.exit(0); }
}