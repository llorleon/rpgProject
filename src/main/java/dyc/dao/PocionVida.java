package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;
import dyc.exception.ObjetosException;

public class PocionVida extends Pocion {

	private byte vidaRecuperada;

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
