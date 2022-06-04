package clases;

import clasesDAO.Arma;
import clasesDAO.Enemigo;

public class Sesion {

	private Personaje personaje;
	private Mapa mapa;

	public Sesion(Personaje personaje, Mapa mapa) {
		super();
		this.personaje = personaje;
		this.mapa = mapa;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

}
