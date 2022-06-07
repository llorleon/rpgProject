package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.clases.ObjetoConNombre;
import dyc.db.ConexionBD;
import dyc.exception.ObjetosException;

/**
 * DAO CREADO PARA GENERAR E INTRODUCIR UN ObjetoDefensivo CON UNOS PUNTOS DE Defensa Y QUE
 * REFERENCIA A UN OBJETO CON NOMBRE
 * 
 * @author victorml
 *
 */

public class ObjetoDefensivo extends ObjetoConNombre {

	private byte puntosDefensa;
	
	
	/**
	 * Metodo usado como constructor de ObjetoDefensivo para cada personaje, con esto le asignamos una por su Nombre en la bd
	 * 
	 * @param armaObjetoNombre paso el objeto de ObjetoDefensivo
	 * @throws SQLException Exception por defecto de SQL
	 * @throws ObjetosException Exception que saco por falta de objeto en la BBDD
	 */

	public ObjetoDefensivo(String defensaObjetoNombre) throws SQLException, ObjetosException {
		super(defensaObjetoNombre);

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt
				.executeQuery("select * from objetoDefensivo where nombre = '" + defensaObjetoNombre + "';");
		if (cursor.next()) {

			this.puntosDefensa = cursor.getByte("puntosDeDefensa");
			setNombre(cursor.getString("nombre"));
		} else {
			throw new ObjetosException("El objeto no existe en la base de datos.");
		}

		// TODO Auto-generated catch block
		ConexionBD.desconectar();

	}

	public byte getPuntosDefensa() {
		return puntosDefensa;
	}

	public void setPuntosDefensa(byte puntosDefensa) {
		this.puntosDefensa = puntosDefensa;
	}

	@Override
	public String toString() {
		return super.toString() + " es un objeto defensivo con Defensa: " + puntosDefensa;
	}

}
