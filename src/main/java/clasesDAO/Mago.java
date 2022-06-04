package clasesDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.ObjetoConNombre;
import clases.Personaje;
import utils.ConexionBD;

public class Mago extends Personaje {

	private int mana;
	private List<Hechizo> hechizos = new ArrayList<Hechizo>();

	public Mago(String nombre, int vida, int ataque, int defensa, List<ObjetoConNombre> inventario, int mana,
			List<Hechizo> hechizos) throws SQLException {
		super(nombre, vida, ataque, defensa, inventario);
		this.mana = mana;
		this.hechizos = hechizos;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public List<Hechizo> getHechizos() {
		return hechizos;
	}

	public void setHechizos(List<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}

	@Override
	public String toString() {
		return "Mago [mana=" + mana + ", hechizos=" + hechizos + "]";
	}

}
