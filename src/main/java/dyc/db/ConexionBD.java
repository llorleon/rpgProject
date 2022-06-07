package dyc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase abstracta que usamos para conectarnos a la BBDD
 * 
 * @author victorml
 *
 */

public abstract class ConexionBD {
	private final static String cadenaConexion = "jdbc:mysql://localhost:3306/dungeon";
	private final static String usuarioBD = "root";
	private final static String passwordBD = "12345678";
	private static Connection conexion; // singleton

	public static Statement conectar() {
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void desconectar() {
		if(conexion!=null) {
			try {
				conexion.close();
				conexion=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
