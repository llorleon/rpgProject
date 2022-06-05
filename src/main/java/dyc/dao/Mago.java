package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;

public class Mago extends Personaje {

	private int mana;
	private Hechizo hechizos;

	public Mago(String nombre, int vida, int ataque, int defensa, List<ObjetoConNombre> inventario, int mana,
			Hechizo hechizos) throws SQLException {
		super(nombre, vida, ataque, defensa, inventario);
		this.mana = mana;
		this.hechizos = hechizos;
	}

	public Mago() throws SQLException {
		ObjetoDefensivo tunica = new ObjetoDefensivo("Tunica de Mago");
		List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();
		inventario.add(tunica);
		setInventario(inventario);
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from mago");

		if (cursor.next()) {

			setNombre(cursor.getString("nombre"));
			setAtaque(cursor.getInt("ataque"));
			setVida(cursor.getInt("vida"));
			setDefensa(cursor.getInt("defensa"));
			this.mana = cursor.getInt("mana");
		}

		ResultSet cursor2 = smt.executeQuery("select * from hechizo WHERE nombre ='Bola de Fuego'");

		if (cursor2.next()) {

			Hechizo bolita = new Hechizo(cursor2.getString("nombre"), cursor2.getInt("puntosAtaque"),
					cursor2.getInt("costeMana"));
			this.hechizos = bolita;

		}
		ConexionBD.desconectar();

	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Hechizo getHechizos() {
		return hechizos;
	}

	public void setHechizos(Hechizo hechizos) {
		this.hechizos = hechizos;
	}

	@Override
	public String toString() {
		return "Mago [mana=" + mana + "\n" + hechizos + "\n"+getInventario();
	}

}
