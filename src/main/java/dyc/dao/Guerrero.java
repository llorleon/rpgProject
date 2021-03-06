package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;
import dyc.exception.ClaseException;
import dyc.exception.ObjetosException;

/**
 * Clase DAO, con esta clase sacamos los datos de la BBDD de esta clase, nombre, ataque, defensa, etc...
 * 
 * @author victorml
 *
 */

public class Guerrero extends Personaje {
	/**
	 * Metodo con el que llamamos al guerrero, con esta en concreto, creariamos un Guerrero que hereda de Personaje
	 * Sacamos sus datos de la BD
	 * 
	 * @throws SQLException Exception por defecto de la BD
	 * @throws ClaseException Exception por no encontrar la clase insertado en BD
	 * @throws ObjetosException Exception lanzada por no tener Objetos en la BD
	 */
	
	public Guerrero() throws SQLException, ClaseException, ObjetosException {

		/**
		 * Asignamos el objetodefensivo, creandole un objeto defensivo a partir de la PK que es el nombre
		 */
		ObjetoDefensivo malla = new ObjetoDefensivo("Cota de malla");
		
		/**
		 * Asignamos el arma, creandole un objeto arma a partir de la PK que es el nombre
		 */
		Arma espadon = new Arma("Espadon");
		/**
		 * Añadimos a la coleccion el arma y el objeto defensivo
		 */
		List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();
		inventario.add(malla);
		inventario.add(espadon);
		
		/**
		 * Hacemos el setinventario para que se actualice con cada play y podamos obtener el contenido
		 */
		setInventario(inventario);
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from guerrero");

		if (cursor.next()) {

			setNombre(cursor.getString("nombre"));
			setAtaque(cursor.getInt("ataque"));
			setVida(cursor.getInt("vida"));
			setMaxVida(getVida());
			setDefensa(cursor.getInt("defensa"));
		} else {
			throw new ClaseException("La clase no existe en la base de datos.");
		}

	}

	@Override
	public String toString() {
		return "Guerrero\n" + super.toString();
	}

}
