package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;

public class PocionMana extends Pocion {

	private byte manaRecuperada;
	private String pocionNombre;
	public PocionMana(String nombre, byte manaRecuperada, String pocionNombre) throws SQLException {
		super(nombre);
		this.manaRecuperada = manaRecuperada;
		this.pocionNombre = pocionNombre;
	}
	
	public PocionMana()throws SQLException{
		super("Pocion Mana");
		
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery(
				"select nombre, manaRecuperado from pocionMana where nombre = '" + pocionNombre + "';");

		if (cursor.next()) {

			this.manaRecuperada = cursor.getByte("manaRecuperado");
			this.pocionNombre = cursor.getString("nombre");
		}
		ConexionBD.desconectar();
		
	}
	public byte getManaRecuperada() {
		return manaRecuperada;
	}
	public void setManaRecuperada(byte manaRecuperada) {
		this.manaRecuperada = manaRecuperada;
	}
	public String getPocionNombre() {
		return pocionNombre;
	}
	public void setPocionNombre(String pocionNombre) {
		this.pocionNombre = pocionNombre;
	}
	@Override
	public String toString() {
		return "PocionMana [Cantidad de Mana recuperado : " + manaRecuperada + ", Nombre del vial de mana : " + pocionNombre + "]";
	}
	
	

}
