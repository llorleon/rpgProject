package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.clases.ObjetoConNombre;
import dyc.db.ConexionBD;
import dyc.exception.ObjetosException;

/**
 * DAO CREADO PARA GENERAR E INTRODUCIR UN ARMA CON UNOS PUNTOS DE ATAQUE Y QUE
 * REFERENCIA A UN OBJETO CON NOMBRE
 * 
 * @author victorml
 *
 */
public class Arma extends ObjetoConNombre {

	private byte puntosAtaque;
	
	/**
	 * Metodo usado como constructor de Arma para cada personaje, con esto le asignamos una por su Nombre en la bd
	 * 
	 * @param armaObjetoNombre paso el objeto de Arma
	 * @throws SQLException Exception por defecto de SQL
	 * @throws ObjetosException Exception que saco por falta de objeto en la BBDD
	 */

	public Arma(String armaObjetoNombre) throws SQLException, ObjetosException {
		super(armaObjetoNombre);

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from arma where nombre = '" + armaObjetoNombre + "';");
		if (cursor.next()) {

			this.puntosAtaque = cursor.getByte("puntosDeAtaque");
			setNombre(cursor.getString("nombre"));
		} else {
			throw new ObjetosException("El objeto no existe en la base de datos.");
		}

		ConexionBD.desconectar();

	}

	public byte getPuntosAtaque() {

		return puntosAtaque;
	}

	public void setPuntosAtaque(byte puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}

	@Override
	public String toString() {
		return super.toString() + " es un arma con Ataque: " + puntosAtaque;
	}

}
