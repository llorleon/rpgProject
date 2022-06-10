package dyc.dao;

import java.sql.SQLException;

import dyc.clases.ObjetoConNombre;

/**
 * Clase que usamos como constructor para añadir hechizos al Mago, en este caso,
 * le añadimos en Mago el hechizo Bola de Fuego con sus stats
 * 
 * @author victorml
 *
 */

public class Hechizo extends ObjetoConNombre {

	/**
	 * El daño de cada hechizo lo determinamos con sus puntos de ataque
	 */
	int puntosAtaque;
	/**
	 * Establecemos el coste de mana de cada hechizo
	 */
	int costeMana;

	/**
	 * Constructor usado para obtener los datos del Hechizo seleccionado, en este
	 * caso usamos el nombre como PK en BD
	 * 
	 * @param nombre       Nombre del hechizo
	 * @param puntosAtaque Daño causado del hechizo
	 * @param costeMana    Coste de Mana del hechizo
	 * @throws SQLException Exception por defecto con SQL
	 */
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
		return "Hechizo " + getNombre() + " con daño " + puntosAtaque + " coste de mana de: " + costeMana;
	}

}
