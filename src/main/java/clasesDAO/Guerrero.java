package clasesDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.ObjetoConNombre;
import clases.Personaje;
import utils.ConexionBD;

public class Guerrero extends Personaje {

	public Guerrero(String nombre, int vida, int ataque, int defensa, List<ObjetoConNombre> inventario)
			throws SQLException {
		super(nombre, vida, ataque, defensa, inventario);
		// TODO Auto-generated constructor stub
	}

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
		return "Guerrero [getVida()=" + getVida() + ", getAtaque()=" + getAtaque() + ", getDefensa()=" + getDefensa()
				+ ", getInventario()=" + getInventario() + ", getNombre()=" + getNombre() + "]";
	}

}
