package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDD {
	public static Connection conectarBaseDatos() {
        Connection con = null;
        

        System.out.println("Intentando conectarse a la base de datos");
        System.out.println("Selecciona centro o fuera de centro: (CENTRO/FUERA)");

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().toLowerCase();

        String URL;
        if(s.equals("centro")) {
            URL = "jdbc:oracle:thin:@//192.168.3.26:1521/XEPDB2";
        } else {
            URL = "jdbc:oracle:thin:@//oracle.ilerna.com:1521/XEPDB2";
        }

        System.out.println("¿Usuario?");
        String USER = scan.nextLine();

        System.out.println("¿Contraseña?");
        String PWD = scan.nextLine();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Conectados a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado el driver " + e);
        } catch (SQLException e) {
            System.out.println("Error en las credenciales o en la URL " + e);
        }

        return con;
    }

	public static Connection conectar(boolean esCentro, String usuarioBd, String pwdBd) {
		// TODO Auto-generated method stub
		return null;
	}

}