package dyc.clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.dao.Enemigo;
import dyc.db.ConexionBD;

public class Lugar extends ObjetoConNombre {
	private Enemigo enemigo;

	public Lugar() throws SQLException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from lugares ORDER BY RAND() LIMIT 1");
		if (cursor.next()) {
			setNombre(cursor.getString("nombre"));
		}

		ConexionBD.desconectar();
		
		enemigo = new Enemigo();
	}

	@Override
	public String toString() {
		return getNombre();
	}

}
