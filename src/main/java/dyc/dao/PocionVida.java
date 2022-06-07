package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;
import dyc.exception.ObjetosException;

/**
 * DAO para recuperar de la BD la pocion de Vida, teniendo tanto la vida recuperado como el nombre de esta pocion
 * 
 * @author victorml
 *
 */

public class PocionVida extends Pocion {

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

	public byte getVidaRecuperada() {
		return vidaRecuperada;
	}

	public void setVidaRecuperada(byte vidaRecuperada) {
		this.vidaRecuperada = vidaRecuperada;
	}

	@Override
	public String toString() {
		return super.toString() + ", pocion de vida que recupera " + vidaRecuperada;
	}

}
