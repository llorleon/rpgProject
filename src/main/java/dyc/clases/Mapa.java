package dyc.clases;

import java.sql.SQLException;

import dyc.dao.Lugar;
import dyc.exception.EnemigoException;
import dyc.exception.ObjetosException;


/**
 * 
 * Clase donde creamos todo lo referente al mapa, asignamos lugares aleatorios en una Matriz
 * 
 * @author victorml
 *
 */
public class Mapa {
	private Lugar[][] lugares;
	private int lugar;
	
	/**
	 * 
	 * Metodo con el cual llamamos a Mapa y generamos el mismo, con un personaje en la primera posicion
	 * 
	 * @param personaje , argumento usado para llamar al Personaje elegido en la seleccion de personaje
	 * @throws SQLException , Exception lanzada por un error con SQL (Por defecto)
	 * @throws EnemigoException , Exception lanzada cuando no encuentra enemigos insertados en la BBDD
	 * @throws ObjetosException , Exception lanzado cuando no encuentra objetos en la BBDD
	 */

	public Mapa(Personaje personaje) throws SQLException, EnemigoException, ObjetosException {
		/**
		 * Creamos una matriz de lugares de 3x3, en el ocurriran eventos de manera aleatoria, pociones, enemigos...
		 */
		lugares = new Lugar[3][3];

		for (int i = 0; i < lugares.length; i++) {
			for (int j = 0; j < lugares[i].length; j++) {
				lugares[i][j] = new Lugar(personaje);
				
				if (i== lugares.length - 1 && j == lugares[i].length - 1) {
					lugares[i][j].setUltimoLugar();
				}
			}
		}

		lugar = 0;
	}
	

	/**
	 * Metodo usado basicamente para recorrer la matriz y avanzar de lugar
	 * 
	 */
	
	public void avanzaLugar() {
		lugar++;
	}
	
	/**
	 * Metodo usado para devolver el lugar en el que estamos actualmente
	 * 
	 * @return Conseguimos el lugar en concreto en el que estamos
	 */

	public Lugar getLugar() {
		int i = lugar / lugares[0].length;
		int j = lugar % lugares[0].length;

		return lugares[i][j];
	}

	@Override
	public String toString() {
		return "Estas en la zona " + getLugar().getNombre();
	}
	
	/**
	 * Con este metodo terminamos la partida si superamos el juego, es decir la ultima casilla de la matriz
	 * @return Terminar el juego a sobrepasar la matriz de 3x3
	 */
	public boolean juegoTerminado() {
		return lugar == (lugares.length * lugares[0].length);
	}
}
