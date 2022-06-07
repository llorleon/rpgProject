package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.db.ConexionBD;
import dyc.exception.ClaseException;
import dyc.exception.ObjetosException;

/**
 * Clase DAO, con esta clase sacamos los datos de la BBDD de esta clase, nombre, ataque, defensa, etc...
 * 
 * @author victorml
 *
 */
public class Mago extends Personaje {
	private int maxMana;
	private int mana;
	private Hechizo hechizo;

	/**
	 * En este metodo conseguimos sacar toda la informacion de la BD de la clase Mago en la BD, le asignamos inventario.
	 * En este metodo tambien asignamos el hechizo al mago, como ataque, en este caso Hechizo bolita, como arma
	 * 
	 * @throws SQLException Error lanzada por defecto en SQL
	 * @throws ClaseException Error lanzado por no existir la clase en la BD
	 * @throws ObjetosException Error lanzada por no haber objeto en la BD
	 */
	
	public Mago() throws SQLException, ClaseException, ObjetosException {
		ObjetoDefensivo tunica = new ObjetoDefensivo("Tunica de Mago");
		List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();
		inventario.add(tunica);
		setInventario(inventario);
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from mago");

		if (cursor.next()) {

			setNombre(cursor.getString("nombre"));
			setAtaque(cursor.getInt("ataque"));
			setVida(cursor.getInt("vida"));
			setDefensa(cursor.getInt("defensa"));
			this.maxMana = cursor.getInt("mana");
			this.mana = this.maxMana;
		} else {
			throw new ClaseException("La clase no existe en la base de datos.");
		}

		ResultSet cursor2 = smt.executeQuery("select * from hechizo WHERE nombre ='Bola de Fuego'");

		if (cursor2.next()) {

			Hechizo bolita = new Hechizo(cursor2.getString("nombre"), cursor2.getInt("puntosAtaque"),
					cursor2.getInt("costeMana"));
			
			
			this.hechizo = bolita;

		} else {
			throw new ObjetosException("El objeto no existe en la base de datos.");
		}
		ConexionBD.desconectar();

	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public Hechizo getHechizo() {
		return hechizo;
	}

	public void setHechizo(Hechizo hechizo) {
		this.hechizo = hechizo;
	}

	/**
	 * Con este metodo conseguimos definir el maximo del mana, para que cuando vayamos a curarnos el mana 
	 * no sobrepasemos el mana maximo
	 * 
	 * @param recupera
	 */
	
	public void recuperaMana(int recupera) {
		mana += recupera;

		if (mana > maxMana) {
			mana = maxMana;
		}
	}

	@Override
	public String toString() {
		return "Mago\n" + super.toString() + "\nMana: " + mana + "\nHechizo: " + hechizo;
	}

}
