package modelo;

import java.sql.*;

public class JugadorDAO {

    // COMPROBAR DUPLICADO
    private static boolean existeNombre(Connection con, String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Jugador WHERE nombrejugador = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }

    // INSERTAR NUEVO JUGADOR
    public static void insertar(int idJugador,
                                String nombre,
                                String pwd,
                                boolean esCentro,
                                String usuarioBd,
                                String pwdBd) {
        String sqlInsert = "INSERT INTO Jugador (id_jugador,nombrejugador,contrasena) VALUES (?,?,?)";
        try (Connection con = BBDD.conectar(esCentro, usuarioBd, pwdBd)) {
            if (existeNombre(con, nombre)) {
                System.out.println("ERROR: El usuario '" + nombre + "' ya existe.");
                return;
            }
            try (PreparedStatement ps = con.prepareStatement(sqlInsert)) {
                ps.setInt(1, idJugador);
                ps.setString(2, nombre);
                ps.setString(3, pwd);
                ps.executeUpdate();
                System.out.println("Jugador registrado con éxito (ID=" + idJugador + ").");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LOGIN (SELECT)
    public static boolean login(String nombre,
                                String pwd,
                                boolean esCentro,
                                String usuarioBd,
                                String pwdBd) {
        String sql = "SELECT 1 FROM Jugador WHERE nombrejugador = ? AND contrasena = ?";
        try (Connection con = BBDD.conectar(esCentro, usuarioBd, pwdBd);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, pwd);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}