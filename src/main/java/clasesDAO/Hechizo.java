package clasesDAO;

import java.sql.SQLException;

import clases.ObjetoConNombre;

public class Hechizo extends ObjetoConNombre {

	int puntosAtaque;
	int costeMana;

	public Hechizo(String nombre, int puntosAtaque, int costeMana) throws SQLException {
		super(nombre);
		this.puntosAtaque = puntosAtaque;
		this.costeMana = costeMana;
	}

	public int getPuntosAtaque() {
		return puntosAtaque;
	}

	public void setPuntosAtaque(int puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}

	public int getCosteMana() {
		return costeMana;
	}

	public void setCosteMana(int costeMana) {
		this.costeMana = costeMana;
	}

	@Override
	public String toString() {
		return "Hechizo "+getNombre()+" con daño "+puntosAtaque+" coste de mana de: "+costeMana;
	}

}
