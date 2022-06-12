package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;
import dyc.exception.ObjetosException;

/**
 * DAO para recuperar de la BD la pocion de Vida, y hereda de Pocion
 * 
 * @author victorml
 *
 */

public class PocionVida extends Pocion {

	/**
	 * Cantidad de vidarecuperada de la pocion
	 */
	private byte vidaRecuperada;

	
	/**
	 * Constructor para llamar a pocion de vida, en esta simplmente creamos el smt para sacar sus datos de la BD
	 * tenemos asi sus estadisticas
	 * 
	 * @throws SQLException Error por defecto de SQL
	 * @throws ObjetosException Exception lanzado por falta de objeto en BD
	 */
	
	public PocionVida() throws SQLException, ObjetosException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from pocionVida;");

		if (cursor.next()) {
			this.vidaRecuperada = cursor.getByte("vidaRecuperada");
			setNombre(cursor.getString("nombre"));
		} else {
			throw new ObjetosException("El objeto no existe en la base de datos.");
		}
		ConexionBD.desconectar();

	}

	/**
	 * Obtenemos la cantidad de vida que recupera pocion de Vida
	 * @return devuelve la cantidad que recupera
	 */
	public byte getVidaRecuperada() {
		return vidaRecuperada;
	}

	/**
	 * Establecemos la cantidad de vida que recuperara la pocion de vida
	 * @param vidaRecuperada cantidad de Vida que se recuperara
	 */
	public void setVidaRecuperada(byte vidaRecuperada) {
		this.vidaRecuperada = vidaRecuperada;
	}

	@Override
	public String toString() {
		return super.toString() + ", pocion de vida que recupera " + vidaRecuperada;
	}

}
