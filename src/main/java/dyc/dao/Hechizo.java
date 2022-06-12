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

	/**
	 * Obtenemos los puntos de ataques del  hechizo
	 * @return entero de daño del hechizo
	 */
	public int getPuntosAtaque() {
		return puntosAtaque;
	}

	/**
	 * Establecemos el daño de ataque del hechizo
	 * @param puntosAtaque entero que da valor al daño del hechizo
	 */
	public void setPuntosAtaque(int puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}

	/**
	 * Obtenemos el coste de mana de cada hechizo
	 * @return devuelve el coste
	 */
	public int getCosteMana() {
		return costeMana;
	}
	
	/**
	 * Establecemos coste de mana de cada hechizo
	 * @param costeMana entero de mana que nos restara al usar un hechizo
	 */

	public void setCosteMana(int costeMana) {
		this.costeMana = costeMana;
	}

	@Override
	public String toString() {
		return "Hechizo " + getNombre() + " con daño " + puntosAtaque + " coste de mana de: " + costeMana;
	}

}
