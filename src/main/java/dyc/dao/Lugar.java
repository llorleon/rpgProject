package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;
import dyc.exception.EnemigoException;

public class Lugar extends ObjetoConNombre {
	private Enemigo enemigo;
	private Pocion pocion;

	public Lugar(Personaje personaje) throws SQLException, EnemigoException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from lugares ORDER BY RAND() LIMIT 1");
		if (cursor.next()) {
			setNombre(cursor.getString("nombre"));
		}

		ConexionBD.desconectar();
		
		enemigo = Enemigo.generaEnemigo();
		pocion = Pocion.generaPocion(personaje instanceof Mago);
	}

	@Override
	public String toString() {
		return getNombre();
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public Pocion getPocion() {
		return pocion;
	}

	public void setPocion(Pocion pocion) {
		this.pocion = pocion;
	}

}
