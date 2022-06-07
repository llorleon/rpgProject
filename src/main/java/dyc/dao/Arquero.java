package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;
import dyc.exception.ClaseException;
import dyc.exception.ObjetosException;

public class Arquero extends Personaje {

	public Arquero() throws SQLException, ClaseException, ObjetosException {

		ObjetoDefensivo cuero = new ObjetoDefensivo("Armadura de Cuero");
		Arma arco = new Arma("Arco Curvo");
		List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();
		inventario.add(cuero);
		inventario.add(arco);
		setInventario(inventario);
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from arquero");

		if (cursor.next()) {

			setNombre(cursor.getString("nombre"));
			setAtaque(cursor.getInt("ataque"));
			setVida(cursor.getInt("vida"));
			setDefensa(cursor.getInt("defensa"));
		} else {
			throw new ClaseException("La clase no existe en la base de datos.");
		}

	}

	@Override
	public String toString() {
		return "Arquero\n" + super.toString();
	}

}
