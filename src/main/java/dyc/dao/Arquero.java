package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;

public class Arquero extends Personaje {

	public Arquero(String nombre, int vida, int ataque, int defensa, List<ObjetoConNombre> inventario)
			throws SQLException {
		super(nombre, vida, ataque, defensa, inventario);
		// TODO Auto-generated constructor stub
	}

	public Arquero() throws SQLException {

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
		}

	}

	@Override
	public String toString() {
		return "Arquero\n" + super.toString();
	}

}
