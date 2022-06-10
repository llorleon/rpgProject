package dyc.clases;

import java.sql.SQLException;

/**
 * Clase usada como superclass para todas las demas clases que tengan un campo String Nombre
 * 
 * @author victorml
 *
 */

public class ObjetoConNombre {
	/**
	 * Esta variable es la usada para poner nombre a todos los objetos que hereden de ObjetoConNombre
	 */
	private String nombre;
	
	/**
	 * Metodo basico de constructor con un nombre String por parametro
	 */

	public ObjetoConNombre(String nombre) throws SQLException {
		super();

		this.nombre = nombre;
	}
	
	/**
	 * Metodo vacio para llamar a objetoConNombre sin parametros
	 */
	public ObjetoConNombre() {
		
	}
	/**
	 * Objetemos el nombre del objeto con getnombre
	 * 
	 * @return devuelve el nombre que se le asigno al elemento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Para asignar un nombre
	 * @param nombre el string de nombre que se le asigna al elemento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

}
