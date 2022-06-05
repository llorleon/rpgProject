package dyc.clases;

import java.sql.SQLException;
import java.util.ArrayList;

import dyc.dao.Enemigo;

public class Mapa {

	public Mapa() throws SQLException {
		Lugar lugares = new Lugar();
		
		System.out.println(lugares.LugarRandom());
		
		
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
}
