package dyc.dao;

import java.sql.SQLException;
import java.util.Random;

import dyc.clases.ObjetoConNombre;
import dyc.exception.ObjetosException;

public class Pocion extends ObjetoConNombre {
	public Pocion() {

	}
	
	public Pocion(String nombre) throws SQLException {
		super(nombre);
	}
	
	public static Pocion generaPocion(boolean mana) throws SQLException, ObjetosException {
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
	
	@Override
	public String toString() {
		return getNombre();
	}
}
