package dyc.clases;

import java.sql.SQLException;

import dyc.exception.EnemigoException;
import dyc.exception.ObjetosException;

/**
 * Clase que usamos basicamente para iniciar la partida, en esta instanciamos personaje y el mapa generado aleatoriamente
 * 
 * 
 * @author victorml
 *
 */

public class Sesion {

	private Personaje personaje;
	private Mapa mapa;

	/**
	 * Metodo vacio para llamar facilmente a sesion sin constructor
	 * 
	 */
	public Sesion() {

	}

	/**
	 * Metodo para recuperar el personaje con el que jugaremos la partida, la clase, arma,etc...
	 * @return
	 */
	public Personaje getPersonaje() {
		return personaje;
	}
	
	/**
	 * Metodo que nos servira para que nos decida que clase escogemos, la llamaremos en la pantalla de eleccion de personajes
	 * 
	 * @param personaje Pasamos la clase, Mago, Arquero o Guerrero
	 * @throws SQLException Exception por defecto de SQL
	 * @throws EnemigoException Exeception si no encuentra enemigos en la BBDD
	 * @throws ObjetosException Exception si no encuentra objetos en la BBDD
	 */

	public void setPersonaje(Personaje personaje) throws SQLException, EnemigoException, ObjetosException {
		this.personaje = personaje;
		mapa = new Mapa(personaje);
	}

	
	/**
	 * Obtenemos el mapa completo con sus enemigos y lugares
	 * @return devuelve el mapa comleto
	 */
	public Mapa getMapa() {
		return mapa;
	}
	
	/**
	 * Establecemos el mapa
	 * @param mapa
	 */

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
}
