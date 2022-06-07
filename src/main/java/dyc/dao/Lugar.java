package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;
import dyc.exception.EnemigoException;
import dyc.exception.ObjetosException;

public class Lugar extends ObjetoConNombre {
	private Enemigo enemigo;
	private Pocion pocion;

	public Lugar(Personaje personaje) throws SQLException, EnemigoException, ObjetosException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from lugares ORDER BY RAND() LIMIT 1");
		if (cursor.next()) {
			setNombre(cursor.getString("nombre"));
		}

		ConexionBD.desconectar();

		enemigo = Enemigo.generaEnemigo();
		pocion = Pocion.generaPocion(personaje instanceof Mago);
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

	@Override
	public String toString() {
		String texto = "Llegas a " + getNombre();

		if (enemigo != null && pocion == null) {
			texto += " y te encuentras un " + enemigo;
		} else if (enemigo == null && pocion != null) {
			texto += " y te encuentras " + pocion;
		} else if (enemigo != null && pocion != null) {
			texto += " y te encuentras un " + enemigo + " que tiene " + pocion;
		}

		return texto;
	}
}
