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
	private int maxMana;
	private int mana;
	private Hechizo hechizo;

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
			this.maxMana = cursor.getInt("mana");
			this.mana = this.maxMana;
		}

		ResultSet cursor2 = smt.executeQuery("select * from hechizo WHERE nombre ='Bola de Fuego'");

		if (cursor2.next()) {

			Hechizo bolita = new Hechizo(cursor2.getString("nombre"), cursor2.getInt("puntosAtaque"),
					cursor2.getInt("costeMana"));
			this.hechizo = bolita;

		}
		ConexionBD.desconectar();

	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public Hechizo getHechizo() {
		return hechizo;
	}

	public void setHechizo(Hechizo hechizo) {
		this.hechizo = hechizo;
	}

	public void recuperaMana(int recupera) {
		mana += recupera;
		
		if (mana > maxMana) {
			mana = maxMana;
		}
	}
	
	@Override
	public String toString() {
		return "Mago\n" + super.toString() + "\nMana: " + mana + "\nHechizo: " + hechizo;
	}

}
