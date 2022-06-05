package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.clases.ObjetoConNombre;
import dyc.db.ConexionBD;

/**
 * DAO CREADO PARA GENERAR E INTRODUCIR UN ARMA CON UNOS PUNTOS DE ATAQUE Y QUE
 * REFERENCIA A UN OBJETO CON NOMBRE
 * 
 * @author victorml
 *
 */
public class Arma extends ObjetoConNombre {

	private byte puntosAtaque;
	private String nombreArma;

	public Arma(byte puntosAtaque, String armaObjetoNombre) throws SQLException {
		super(armaObjetoNombre);

		this.puntosAtaque = puntosAtaque;
		this.nombreArma = armaObjetoNombre;

	}

	public Arma(String armaObjetoNombre) throws SQLException {
		super(armaObjetoNombre);

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery(
				"select * from arma where nombre = '" + armaObjetoNombre + "';");
		if (cursor.next()) {

			this.puntosAtaque = cursor.getByte("puntosDeAtaque");
			this.nombreArma = cursor.getString("nombre");
		}

		// TODO Auto-generated catch block
		ConexionBD.desconectar();

	}

	public byte getPuntosAtaque() {

		return puntosAtaque;
	}

	public void setPuntosAtaque(byte puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}

	public void setArmaObjetoNombre(String armaObjetoNombre) {
		this.nombreArma = armaObjetoNombre;
	}

	@Override
	public String toString() {
		return "Arma [Puntos de ataque =" + puntosAtaque + ", Nombre del Arma = " + nombreArma + "]";
	}

}
