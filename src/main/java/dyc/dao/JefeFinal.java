package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import dyc.clases.ObjetoConNombre;
import dyc.db.ConexionBD;
import dyc.exception.EnemigoException;

/**
 * Clase DAO que extiende de Objeto con nombre y obtenemos los datos de un JefeFinal
 * 
 * @author victorml
 *
 */

public class JefeFinal extends ObjetoConNombre {

	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	
	/**
	 * Metodo para generar y recoger todas las estadisticas del jefe final, en este caso usando su Nombre directo desde BD obtenemos al Jefe
	 * 
	 * @throws SQLException
	 * @throws EnemigoException
	 */

	public JefeFinal() throws SQLException, EnemigoException {
		super("Cermuzork, El Goblin Primigenio");

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from jefeFinal ORDER BY RAND() LIMIT 1");

		if (cursor.next()) {
			this.nombre = cursor.getString("nombre");
			this.vida = cursor.getInt("vida");
			this.ataque = cursor.getInt("ataque");
			this.defensa = cursor.getInt("defensa");
		} else {
			throw new EnemigoException("No hay enemigos en la base de datos");
		}

		ConexionBD.desconectar();

	}

	/**
	 * Metodo que nos sirve para generar un enemigo en la ultima casilla del mapa
	 * 
	 * @return Devuelve un JefeFinal
	 * @throws SQLException Exception por defecto de SQL
	 * @throws EnemigoException Exeption creada al no estar el jefe en BD
	 */
	public static JefeFinal generaJefe() throws SQLException, EnemigoException {
		JefeFinal jefeFinal;
		Random random = new Random();

		if (random.nextBoolean() == true) {
			jefeFinal = new JefeFinal();
		} else {
			jefeFinal = null;
		}

		return jefeFinal;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	@Override
	public String toString() {
		return "JefeFinal [nombre=" + nombre + ", vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + "]";
	}

}
