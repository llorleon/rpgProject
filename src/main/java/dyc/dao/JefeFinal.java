package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;
import dyc.exception.EnemigoException;

/**
 * Clase DAO que extiende enemigo y obtenemos los datos de un JefeFinal
 * 
 * @author victorml
 *
 */

public class JefeFinal extends Enemigo {
	/**
	 * Metodo para generar y recoger todas las estadisticas del jefe final, en este caso usando su Nombre directo desde BD obtenemos al Jefe
	 * 
	 * @throws SQLException
	 * @throws EnemigoException
	 */

	public JefeFinal() throws SQLException, EnemigoException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from jefeFinal ORDER BY RAND() LIMIT 1");

		if (cursor.next()) {
			setNombre(cursor.getString("nombre"));
			setVida(cursor.getInt("vida"));
			setAtaque(cursor.getInt("ataque"));
			setDefensa(cursor.getInt("defensa"));
		} else {
			throw new EnemigoException("No hay enemigos en la base de datos");
		}

		ConexionBD.desconectar();
	}
}
