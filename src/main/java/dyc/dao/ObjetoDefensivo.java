package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.clases.ObjetoConNombre;
import dyc.db.ConexionBD;

public class ObjetoDefensivo extends ObjetoConNombre {

	private byte puntosDefensa;
	private String defensaObjetoNombre;

	public ObjetoDefensivo(byte puntosDefensa, String defensaObjetoNombre) throws SQLException {
		super(defensaObjetoNombre);

		this.puntosDefensa = puntosDefensa;
		this.defensaObjetoNombre = defensaObjetoNombre;
	}

	public ObjetoDefensivo(String defensaObjetoNombre) throws SQLException {
		super(defensaObjetoNombre);

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery(
				"select * from objetoDefensivo where nombre = '" + defensaObjetoNombre + "';");
		if (cursor.next()) {

			this.puntosDefensa = cursor.getByte("puntosDeDefensa");
			this.defensaObjetoNombre = cursor.getString("nombre");
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

	public String getDefensaObjetoNombre() {
		return defensaObjetoNombre;
	}

	public void setDefensaObjetoNombre(String defensaObjetoNombre) {
		this.defensaObjetoNombre = defensaObjetoNombre;
	}

	@Override
	public String toString() {
		return "ObjetoDefensivo [Puntos de defensa :" + puntosDefensa + ", Nombre de la armadura : " + defensaObjetoNombre + "]";
	}

}
