package dyc.dao;

import java.sql.SQLException;
import java.util.Random;

import dyc.clases.ObjetoConNombre;
import dyc.exception.ObjetosException;

/**
 * Superclase que usaremos para pociones de vida y de mana, de esta manera podremos generarlas de manera aleatoria
 * 
 * @author victorml
 *
 */

public class Pocion extends ObjetoConNombre {
	public Pocion() {

	}
	
	public Pocion(String nombre) throws SQLException {
		super(nombre);
	}
	
	/**
	 * Metodo usado para generar pociones de manera aleatoria en el mapa, con una tirada del 50%
	 * 
	 * @param mana este parametro es usado para que solo se generen pociones de mana cuando haya un Mago en la partida
	 * @return devuelve pocion si hay algun true
	 * @throws SQLException Devuelve exception por defecto de SQL
	 * @throws ObjetosException Devuelve Exception si no estan las pociones añadidas a la BD
	 */
	public static Pocion generaPocion(boolean mana) throws SQLException, ObjetosException {
		Pocion pocion;
		Random random = new Random(); 
		
		if (random.nextBoolean() == true) {
			if (!mana || random.nextBoolean() == true) {
				pocion = new PocionVida();				
			} else {
				pocion = new PocionMana();	
			}
			
		} else {
			pocion = null;
		}
		
		return pocion;
	}
	
	@Override
	public String toString() {
		return getNombre();
	}
}
