package dyc.clases;

import java.sql.SQLException;

import dyc.dao.Lugar;
import dyc.exception.EnemigoException;
import dyc.exception.ObjetosException;

public class Mapa {
	private Lugar[][] lugares;
	private int lugar;

	public Mapa(Personaje personaje) throws SQLException, EnemigoException, ObjetosException {
		lugares = new Lugar[3][3];

		for (int i = 0; i < lugares.length; i++) {
			for (int j = 0; j < lugares[i].length; j++) {
				lugares[i][j] = new Lugar(personaje);
			}
		}

		lugar = 0;
	}

	public void avanzaLugar() {
		lugar++;
	}

	public Lugar getLugar() {
		int i = lugar / lugares[0].length;
		int j = lugar % lugares[0].length;

		return lugares[i][j];
	}

	@Override
	public String toString() {
		return "Estas en la zona " + getLugar().getNombre();
	}
}
