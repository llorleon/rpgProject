package clasesDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.ObjetoConNombre;
import utils.ConexionBD;

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
				"select nombre, puntosDefensivos from objetoDefensivo where nombre = '" + defensaObjetoNombre + "';");

		if (cursor.next()) {

			this.puntosDefensa = cursor.getByte("puntosDefensivos");
			this.defensaObjetoNombre = cursor.getString("nombre");
		}
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
