package vista;

	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.MenuItem;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.event.ActionEvent;
	import javafx.scene.Node;

	public class Pantalla_PrincipalController {

	@FXML private MenuItem newGame;
	@FXML private MenuItem saveGame;
    @FXML private MenuItem loadGame;
	@FXML private MenuItem quitGame;

	@FXML private TextField userField;
	@FXML private PasswordField passField;

	@FXML private Button loginButton;
	@FXML private Button registerButton;

	@FXML
	private void initialize() {
		// Este método se llama automáticamente después de cargar el FXML.
		// Puede establecer valores iniciales o agregar oyentes aquí.
		   System.out.println("pantallaPrincipalController initialized");
	}

	@FXML
	private void handleNewGame() {
		   System.out.println("Se hizo clic en nuevo juego");
		   // TODO
	}

    @FXML
	private void handleSaveGame() {
		  System.out.println("Se hizo clic en Guardar juego");
		    // TODO
	}

	@FXML
	private void handleLoadGame() {
		   System.out.println("Cargar juego hecho clic");
		   // TODO
	}

	 @FXML
	private void handleQuitGame() {
		   System.out.println("Se hizo clic para salir del juego");
		   // TODO
		   System.exit(0);
	}
		    
	@FXML
	//login
	private void handleLogin(ActionEvent event) {
		  String username = userField.getText();
		  String password = passField.getText();

		   System.out.println("Iniciar sesión presionado: " + username + " / " + password);

		  //  Cequeig bosic de login
		   if (!username.isEmpty() && !password.isEmpty()) {
		       try {
		           FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaJuego.fxml"));
		           Parent pantallaJuegoRoot = loader.load();

		           Scene pantallaJuegoScene = new Scene(pantallaJuegoRoot);

		           // consegir la stage actual amb el event
		          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		           stage.setScene(pantallaJuegoScene);
		           stage.setTitle("Pantalla de Juego");
		       } catch (Exception e) {
		           e.printStackTrace();
		       }
		  } else {
		       System.out.println("Por favor, introduzca su usuario y contraseña..");
		  }
	}


	@FXML
	private void handleRegister() {
		  System.out.println("Registro presionado");
		  // TODO
	}
}