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

        String
            URL = "jdbc:oracle:thin:@//192.168.3.26:1521/XEPDB2";
      
        String USER = "DM2425_PIN_GRUP08";

     
        String PWD = "ABBMR08";

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