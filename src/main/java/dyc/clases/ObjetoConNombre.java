package dyc.clases;

import java.sql.SQLException;

/**
 * Clase usada como superclass para todas las demas clases que tengan un campo String Nombre
 * 
 * @author victorml
 *
 */

public class ObjetoConNombre {
	private String nombre;

	public ObjetoConNombre(String nombre) throws SQLException {
		super();

		this.nombre = nombre;
	}
	
	public ObjetoConNombre() {
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

}
