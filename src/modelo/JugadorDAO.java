package modelo;

import java.sql.*;

public class JugadorDAO {


	  public static void insertar(int id, String nombre, String pwd, boolean esCentro, String usuarioBd, String pwdBd) throws Exception {
	        String sql = "INSERT INTO Jugador (id_jugador, nombrejugador, contraseña) VALUES (?, ?, ?)";

	        try (Connection con = BBDD.conectarBaseDatos();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ps.setString(2, nombre);
	            ps.setString(3, pwd);

	            ps.executeUpdate();
	            System.out.println("Jugador registrado con éxito (ID=" + id + ").");
	        }
	    }

	    public static boolean existe(String nombre, String pwd, boolean esCentro, String usuarioBd, String pwdBd) throws Exception {
	        String sql = "SELECT * FROM Jugador WHERE nombrejugador = ? AND contraseña = ?";

	        try (Connection con = BBDD.conectarBaseDatos();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, nombre);
	            ps.setString(2, pwd);

	            return ps.executeQuery().next();
	        }
	    }
	}