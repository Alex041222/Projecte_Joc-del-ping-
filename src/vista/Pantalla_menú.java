package vista;

import modelo.BBDD;
import controlador.Gestor_Usuario;

import java.sql.Connection;
import java.util.Scanner;


public class Pantalla_menú {

	public static void main(String[] args) {
        Connection con = BBDD.conectarBaseDatos();

        if (con != null) {
            Scanner scan = new Scanner(System.in);

            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Registrar jugador");
            System.out.println("2. Iniciar sesión");
            int opcion = scan.nextInt();
            scan.nextLine();

            System.out.print("Nombre de jugador: ");
            String nombre = scan.nextLine();

            System.out.print("Contraseña: ");
            String contraseña = scan.nextLine();

            try {
                if (opcion == 1) {
                    System.out.print("ID del jugador (número): ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    Gestor_Usuario.registrarJugador(con, id, nombre, contraseña);
                } else if (opcion == 2) {
                    boolean ok = Gestor_Usuario.loginJugador(con, nombre, contraseña);
                    System.out.println(ok
                        ? "Login exitoso."
                        : "Usuario o contraseña incorrectos.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}