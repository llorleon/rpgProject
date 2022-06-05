package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;

public class PocionVida extends Pocion {

	private byte vidaRecuperada;
	private String pocionNombre;

	public PocionVida(String nombre, byte vidaRecuperada, String pocionNombre) throws SQLException {
		super(nombre);
		this.vidaRecuperada = vidaRecuperada;
		this.pocionNombre = pocionNombre;
	}
	
	public PocionVida()throws SQLException{
		super("Frasco Estus");
		
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery(
				"select nombre, vidaRecuperada from pocionVida where nombre = '" + pocionNombre + "';");

		if (cursor.next()) {

			this.vidaRecuperada = cursor.getByte("vidaRecuperada");
			this.pocionNombre = cursor.getString("nombre");
		}
		ConexionBD.desconectar();
		
	}
	
	public byte getVidaRecuperada() {
		return vidaRecuperada;
	}

	public void setVidaRecuperada(byte vidaRecuperada) {
		this.vidaRecuperada = vidaRecuperada;
	}

	public String getPocionNombre() {
		return pocionNombre;
	}

	public void setPocionNombre(String pocionNombre) {
		this.pocionNombre = pocionNombre;
	}

	@Override
	public String toString() {
		return "PocionVida [Vida que recupera : " + vidaRecuperada + ", Nombre del vial : " + pocionNombre + "]";
	}

}
