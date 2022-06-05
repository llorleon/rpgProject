package dyc.clases;

import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;

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

}
