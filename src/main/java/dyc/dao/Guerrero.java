package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;

public class Guerrero extends Personaje {

	public Guerrero() throws SQLException {

		ObjetoDefensivo malla = new ObjetoDefensivo("Cota de malla");
		Arma espadon = new Arma("Espadon");
		List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();
		inventario.add(malla);
		inventario.add(espadon);
		setInventario(inventario);
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from guerrero");

		if (cursor.next()) {

			setNombre(cursor.getString("nombre"));
			setAtaque(cursor.getInt("ataque"));
			setVida(cursor.getInt("vida"));
			setDefensa(cursor.getInt("defensa"));
		}

	}

	@Override
	public String toString() {
		return "Guerrero\n" + super.toString();
	}

}
