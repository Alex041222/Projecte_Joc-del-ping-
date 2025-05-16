package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.BBDD;
import java.sql.*;
public class Gestor_Usuario {

	 /** Inserta usando la conexión ya abierta */
    public static void registrarJugador(Connection con,
                                         int idJugador,
                                         String nombre,
                                         String pwd) throws SQLException {
        String sqlCheck  = "SELECT COUNT(*) FROM Jugador WHERE nombrejugador = ?";
        String sqlInsert = "INSERT INTO Jugador (id_jugador,nombrejugador,contraseña) VALUES (?,?,?)";

        // 1) compruebo si existe
        try (PreparedStatement ps = con.prepareStatement(sqlCheck)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("ERROR: el usuario '" + nombre + "' ya existe.");
                return;
            }
        }
        // 2) inserto
        try (PreparedStatement ps = con.prepareStatement(sqlInsert)) {
            ps.setInt(1, idJugador);
            ps.setString(2, nombre);
            ps.setString(3, pwd);
            ps.executeUpdate();
            System.out.println("Jugador registrado con éxito (ID=" + idJugador + ").");
        }
    }

    /** Comprueba credenciales usando la conexión ya abierta */
    public static boolean loginJugador(Connection con,
                                       String nombre,
                                       String pwd) throws SQLException {
        String sql = "SELECT 1 FROM Jugador WHERE nombrejugador = ? AND contraseña = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
}