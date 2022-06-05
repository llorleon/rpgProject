package dyc.dao;

import java.sql.SQLException;
import java.util.Random;

import dyc.clases.ObjetoConNombre;

public class Pocion extends ObjetoConNombre {
	public Pocion(String nombre) throws SQLException {
		super(nombre);
	}
	
	public static Pocion generaPocion(boolean mana) throws SQLException {
		Pocion pocion;
		Random random = new Random(); 
		
		if (random.nextBoolean() == true) {
			if (!mana || random.nextBoolean() == true) {
				pocion = new PocionVida();				
			} else {
				pocion = new PocionMana();	
			}
			
		} else {
			pocion = null;
		}
		
		return pocion;
	}
}
