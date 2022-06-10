package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dyc.db.ConexionBD;
import dyc.exception.ObjetosException;

/**
 * DAO para recuperar de la BD la pocion de Mana, teniendo tanto el mana recuperado como el nombre de esta pocion
 * Esta solo podra ser usada por el Mago
 * Hereda de pocion
 * @author victorml
 *
 */
public class PocionMana extends Pocion {

	/**
	 * Cantidad de mana que recupera la pocion
	 */
	private byte manaRecuperada;
	
	/**
	 * Constructor para llamar a pocion de mana, en esta simplmente creamos el smt para sacar sus datos de la BD
	 * tenemos asi sus estadisticas
	 * 
	 * @throws SQLException Error por defecto de SQL
	 * @throws ObjetosException Exception lanzado por falta de objeto en BD
	 */
	public PocionMana() throws SQLException, ObjetosException{
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from pocionMana;");

		if (cursor.next()) {
			this.manaRecuperada = cursor.getByte("manaRecuperado");
			setNombre(cursor.getString("nombre"));
		}else {
			throw new ObjetosException("El objeto no existe en la base de datos.");
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
