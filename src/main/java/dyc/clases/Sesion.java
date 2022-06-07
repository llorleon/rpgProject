package dyc.clases;

import java.sql.SQLException;

import dyc.exception.EnemigoException;
import dyc.exception.ObjetosException;

public class Sesion {

	private Personaje personaje;
	private Mapa mapa;

	public Sesion() {

	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) throws SQLException, EnemigoException, ObjetosException {
		this.personaje = personaje;
		mapa = new Mapa(personaje);
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
}
