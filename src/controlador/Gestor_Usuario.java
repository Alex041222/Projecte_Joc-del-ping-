package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gestor_Usuario {
	  public static void registrarJugador(Connection con, int id, String nombre, String contraseña) {
	        String sql = "INSERT INTO Jugador (id_jugador, nombrejugador, contraseña) VALUES (?, ?, ?)";

	        try (PreparedStatement pst = con.prepareStatement(sql)) {
	            pst.setInt(1, id);
	            pst.setString(2, nombre);
	            pst.setString(3, contraseña);
	            pst.executeUpdate();
	            System.out.println("Jugador registrado con éxito.");
	        } catch (SQLException e) {
	            System.out.println("Error al registrar jugador: " + e.getMessage());
	        }
	    }

	    public static boolean loginJugador(Connection con, String nombre, String contraseña) {
	        String sql = "SELECT * FROM Jugador WHERE nombrejugador = ? AND contraseña = ?";

	        try (PreparedStatement pst = con.prepareStatement(sql)) {
	            pst.setString(1, nombre);
	            pst.setString(2, contraseña);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                System.out.println("Login exitoso. Bienvenido, " + nombre);
	                return true;
	            } else {
	                System.out.println("Nombre o contraseña incorrectos.");
	                return false;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error en el login: " + e.getMessage());
	            return false;
	        }
	    }
	}