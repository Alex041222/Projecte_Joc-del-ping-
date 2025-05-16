package controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.BBDD;

public class Gestor_Jugador {
	   // Llista de jugadors
    private final List<Jugador> jugadors = new ArrayList<>();

    // Classe interna per a Jugador 
    public static class Jugador {
        public final String nom;
        public int puntuacio;
        
        public Jugador(String nom, int puntuacio) {
            this.nom = nom;
            this.puntuacio = puntuacio;
        }

		public static void insertar(int idJugador, String nombre, String pwd, 
				String centro, String usuarioBd,String pwdBd) throws SQLException {
			
			 boolean esCentro = "CENTRO".equalsIgnoreCase(centro);
		        String sqlInsert = "INSERT INTO Jugador (id_jugador, nombrejugador, contraseña) VALUES (?, ?, ?)";

		        try (Connection con = BBDD.conectar(esCentro, usuarioBd, pwdBd)) {
		            // 1) Compruebo si ya existe ese nombre
		            if (existeNombre(con, nombre)) {
		                System.out.println("ERROR: El usuario '" + nombre + "' ya existe. Elige otro nombre.");
		                return;
		            }

		            // 2) Si no existe, inserto
		            try (PreparedStatement ps = con.prepareStatement(sqlInsert)) {
		                ps.setInt(1, idJugador);
		                ps.setString(2, nombre);
		                ps.setString(3, pwd);
		                int filas = ps.executeUpdate();
		                if (filas == 1) {
		                    System.out.println("Jugador registrado con éxito (ID=" + idJugador + ").");
		                } else {
		                    System.out.println("No se pudo registrar al jugador.");
		                }
		            }

		        }
		    }
		}
		/**
	     * Comprueba si existe un jugador con ese nombre.
	     */
	    private static boolean existeNombre(Connection con, String nombre) throws SQLException {
	        String sqlCheck = "SELECT COUNT(*) FROM Jugador WHERE nombrejugador = ?";
	        try (PreparedStatement ps = con.prepareStatement(sqlCheck)) {
	            ps.setString(1, nombre);
	            try (ResultSet rs = ps.executeQuery()) {
	                rs.next();
	                return rs.getInt(1) > 0;
	            }
	        }
	    }
	    /**
	     * Inserta un nuevo jugador solo si no existe todavía.
	     *
	     * @param idJugador  ID que asignas al jugador.
	     * @param nombre     Nombre de usuario.
	     * @param pwd        Contraseña (texto plano).
	     * @param centro     "CENTRO" o "FUERA" para elegir URL.
	     * @param usuarioBd  Usuario Oracle (ej. "YASMINA").
	     * @param pwdBd      Contraseña Oracle.
	     */
	    
    // Singleton
    private static Gestor_Jugador instancia;
    public static Gestor_Jugador getInstancia() {
        if (instancia == null) {
            instancia = new Gestor_Jugador();
        }
        return instancia;
    }

    // Afegir jugador
    public void afegirJugador(String nom, int puntuacio) {
        jugadors.add(new Jugador(nom, puntuacio));
    }

    // Obtenir llista de jugadors 
    public List<Jugador> getJugadors() {
        return new ArrayList<>(jugadors);
    }

    // Eliminar jugador 
    public void eliminarJugador(String nom) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < jugadors.size()) {
            if (jugadors.get(i).nom.equals(nom)) {
                jugadors.remove(i);
                trobat = true;
            }
            i++;
        }
    }
}