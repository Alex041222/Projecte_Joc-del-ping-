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
            scan.nextLine(); // limpiar buffer

            System.out.print("Nombre de jugador: ");
            String nombre = scan.nextLine();

            System.out.print("Contraseña: ");
            String contraseña = scan.nextLine();

            if (opcion == 1) {
                System.out.print("ID del jugador (número): ");
                int id = scan.nextInt();
                scan.nextLine(); // limpiar buffer
                Gestor_Usuario.registrarJugador(con, id, nombre, contraseña);
            } else if (opcion == 2) {
                boolean loginExitoso = Gestor_Usuario.loginJugador(con, nombre, contraseña);
                if (loginExitoso) {
                    // Aquí podrías continuar al menú del juego o lo que necesites
                }
            }
        }
    }
}