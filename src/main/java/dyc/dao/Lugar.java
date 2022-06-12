package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;
import dyc.exception.EnemigoException;
import dyc.exception.ObjetosException;

/**
 * Clase DAO que hereda de ObjetoConNombre, obtenemos zonas aleatorias de la BD
 * 
 * @author victorml
 *
 */

public class Lugar extends ObjetoConNombre {
	private Enemigo enemigo;
	private Pocion pocion;

	/**
	 * Constructor de lugar, en este lugar llamamos como argumento a personaje y de esta manera podemos llevarlo al Mapa, en este lugar
	 * de manera aleatoria llamaremos un enemigo de manera aleatoria y una pocion de manera aleatoria
	 * 
	 * @param personaje Peronsaje que elegimos en la seleccion de personajes
	 * @throws SQLException Exception por defecto
	 * @throws EnemigoException Exception por falta de Enemigos en la BD
	 * @throws ObjetosException Exception lanzada por falta de objetos en la BD
	 */
	
	public Lugar(Personaje personaje) throws SQLException, EnemigoException, ObjetosException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from lugares ORDER BY RAND() LIMIT 1");
		if (cursor.next()) {
			setNombre(cursor.getString("nombre"));
		}

		ConexionBD.desconectar();

		enemigo = Enemigo.generaEnemigo();
		pocion = Pocion.generaPocion(personaje instanceof Mago);
	}

	/**
	 * Obtenemos el enemigo que esta puesto en un lugar del mapa
	 * @return nos devuelve el enemigo
	 */
	public Enemigo getEnemigo() {
		return enemigo;
	}
	/**
	 * Establecemos un enemigo en un lugar
	 * @param enemigo pasamos por argumento un enemigo
	 */

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	/**
	 * Obtenemos si hay pocion en un lugar
	 * @return devuelve una pocion
	 */ 
	public Pocion getPocion() {
		return pocion;
	}

	/**
	 * Establecemos una pocion en un lugar
	 * @param pocion argumento pasamos una pocion de algun tipo, vida o mana
	 */
	public void setPocion(Pocion pocion) {
		this.pocion = pocion;
	}

	/**
	 * To string para representar la zona, si hay pocion, si hay enemigo, si no hay nada, si hay ambos
	 * 
	 */
	
	@Override
	public String toString() {
		String texto = "Llegas a " + getNombre();

		if (enemigo != null && pocion == null) {
			texto += " y te encuentras un " + enemigo;
		} else if (enemigo == null && pocion != null) {
			texto += " y te encuentras " + pocion;
		} else if (enemigo != null && pocion != null) {
			texto += " y te encuentras un " + enemigo + " que tiene " + pocion;
		}

		return texto;
	}
	/**
	 * Setter usado para determinar el ultimo lugar del mapa, en el que SI o SI tenga un enemigo final
	 * @throws EnemigoException devuelve error si el enemigo no existe en la BBDD
	 * @throws SQLException error por defecto de SQL
	 */
	public void setUltimoLugar() throws EnemigoException, SQLException {
		enemigo = new JefeFinal();
	}
}
