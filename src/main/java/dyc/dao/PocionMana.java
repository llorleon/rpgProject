package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;

public class PocionMana extends Pocion {

	private byte manaRecuperada;
	
	public PocionMana()throws SQLException{
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from pocionMana;");

		if (cursor.next()) {
			this.manaRecuperada = cursor.getByte("manaRecuperado");
			setNombre(cursor.getString("nombre"));
		}
		ConexionBD.desconectar();
		
	}
	public byte getManaRecuperada() {
		return manaRecuperada;
	}
	public void setManaRecuperada(byte manaRecuperada) {
		this.manaRecuperada = manaRecuperada;
	}
	@Override
	public String toString() {
		return super.toString() + ", pocion de mana que recupera " + manaRecuperada;
	}
}
