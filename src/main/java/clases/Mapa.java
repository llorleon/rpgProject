package clases;

import java.sql.SQLException;
import java.util.ArrayList;

import clasesDAO.Enemigo;

public class Mapa {

	public Mapa() throws SQLException {
		
		Lugar lugares = new Lugar();
		Enemigo enemigos = new Enemigo();
		
		System.out.println(lugares.LugarRandom());
		
		
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
}
