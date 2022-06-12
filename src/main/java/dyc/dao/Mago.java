package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
public class Mago extends Personaje {
	/**
	 * Establecemos un mana maximo para que no podamos sobrepasarlo con las pociones de mana
	 */
	private int maxMana;
	/**
	 * Establecemos el mana base del mago
	 */
	private int mana;
	/**
	 * Coleccion de hechizos que puede lanzar 
	 */
	private HashMap<String, Hechizo> hechizos;
	

	/**
	 * En este metodo conseguimos sacar toda la informacion de la BD de la clase Mago en la BD, le asignamos inventario.
	 * En este metodo tambien asignamos los hechizos al mago con una coleccion 
	 * @throws SQLException Error lanzada por defecto en SQL
	 * @throws ClaseException Error lanzado por no existir la clase en la BD
	 * @throws ObjetosException Error lanzada por no haber objeto en la BD
	 */
	
	public Mago() throws SQLException, ClaseException, ObjetosException {
		/**
		 * Asignamos el objetodefensivo, creandole un objeto defensivo a partir de la PK que es el nombre
		 */
		
		PocionMana pocionMana = new PocionMana();
		
		ObjetoDefensivo tunica = new ObjetoDefensivo("Tunica de Mago");
		List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();
		inventario.add(tunica);
		/**
		 * Hago que el mago empiece siempre con una pocion de Mana
		 */
		inventario.add(pocionMana);
		/**
		 * Añadimos a la coleccion el objeto defensivo
		 */
		setInventario(inventario);
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from mago");
		hechizos = new HashMap<>();

		if (cursor.next()) {

			setNombre(cursor.getString("nombre"));
			setAtaque(cursor.getInt("ataque"));
			setVida(cursor.getInt("vida"));
			setMaxVida(getVida());
			setDefensa(cursor.getInt("defensa"));
			this.maxMana = cursor.getInt("mana");
			this.mana = this.maxMana;
		} else {
			throw new ClaseException("La clase no existe en la base de datos.");
		}

		ResultSet cursor2 = smt.executeQuery("select * from hechizo"); 
		
		/**
		 * Con este while recorremos el hashmap para obtener los hechizos que tendra el mago
		 */

		while (cursor2.next()) {
			Hechizo hechizo = new Hechizo(cursor2.getString("nombre"), cursor2.getInt("puntosAtaque"),
					cursor2.getInt("costeMana"));
			
			
			hechizos.put(hechizo.getNombre(), hechizo);
		}
		
		if (hechizos.isEmpty()) {
			throw new ObjetosException("No hay hechizos en la base de datos.");
		}
		
		ConexionBD.desconectar();

	}

	/**
	 * Obtenemos el mana del Mago
	 * @return devuelve entero del mana del mago
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Establecemos valor al mana del Mago
	 * @param mana entero que define el mana del MAgo
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}

	/**
	 * Obtenemos el maximo de mana del Mago, para no sobrepasarlo con pociones de Mana
	 * @return devuelve el maximo valor del Mana
	 */
	public int getMaxMana() {
		return maxMana;
	}

	/**
	 * Establecemos el valor maximo del Mana
	 * 
	 * @param maxMana argumento entero para definir el Manaa Maximo
	 */
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	/**
	 * Con este metodo conseguimos definir el maximo del mana, para que cuando vayamos a curarnos el mana 
	 * no sobrepasemos el mana maximo
	 * 
	 * @param recupera
	 */
	
	public void recuperaMana(int recupera) {
		mana += recupera;

		if (mana > maxMana) {
			mana = maxMana;
		}
	}

	@Override
	public String toString() {
		String resultado = "Mago\n" + super.toString() + "\nMana: " + mana + "\nHechizos:\n";
		
		for (Hechizo hechizo : hechizos.values()) {
			resultado += hechizo + "\n";
		}
		
		return resultado;
	}
	
	/**
	 * Metodo para establecer los hechizos al mago
	 * @return devuelve la asignacion de hechizos a la coleccion
	 */
	public Set<String> getHechizos() {
		return hechizos.keySet();
	}
	
	
	public Hechizo getHechizo(String nombre) {
		return hechizos.get(nombre);
	}

	/**
	 * Metodo usado para que el mana se gaste con cada hechizo que gastamos
	 * @param mana usamos por parametro el coste de mana del hechizo para descontarlo del mana del mago
	 */
	public void consumeMana(int mana) {
		this.mana -= mana;
	}
}
