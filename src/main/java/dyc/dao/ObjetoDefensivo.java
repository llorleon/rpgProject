package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.clases.ObjetoConNombre;
import dyc.db.ConexionBD;
import dyc.exception.ObjetosException;

public class ObjetoDefensivo extends ObjetoConNombre {

	private byte puntosDefensa;

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
