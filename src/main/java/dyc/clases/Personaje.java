package dyc.clases;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dyc.dao.PocionMana;
import dyc.dao.PocionVida;


/**
 * Superclase que hereda de ObjetoConNombre y que nos sirve de superclass para las distintas clases
 * En este caso es abstract dado que no sabemos que clase somos
 * 
 * @author victorml
 *
 */

public abstract class Personaje extends ObjetoConNombre {
	private int maxVida;
	private int vida;
	private int ataque;
	private int defensa;
	private List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();
	
	/**
	 * Metodo que nos sirve como constructor principal de un personaje, pero que basicamente solo usaremos para crear las clases
	 * 
	 * @param nombre String heredado de ObjetoConNombre con el cual ponemos nombre a la clase
	 * @param maxVida Con esto limitamos la vida maxima del personaje, para no pasarnos de su vidaMaxima al recuperar Vida
	 * @param ataque Ataque base del personaje sin tener en cuenta su arma
	 * @param defensa Defensa basica del personake sin tener en cuenta su objetoDefensivo
	 * @param inventario List de arraylist, del que obtenemos el arma, objetodefensivo y si tiene pociones en el
	 * @throws SQLException Error por defecto Lanzado por SQL
	 */

	public Personaje(String nombre, int maxVida, int ataque, int defensa, List<ObjetoConNombre> inventario)
			throws SQLException {
		super(nombre);
		this.maxVida = maxVida;
		this.vida = maxVida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.inventario = inventario;
	}

	public Personaje() {
		
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getMaxVida() {
		return maxVida;
	}

	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public List<ObjetoConNombre> getInventario() {
		return inventario;
	}
/**
 * Metodo con el que asignamos un objeto al inventario del personaje
 * 
 * @param arraylist de inventario al que añadiremos los objetos en cada clase, mago, guerrero, arquero...
 */
	
	public void setInventario(List<ObjetoConNombre> inventario) {
		this.inventario = inventario;
	}
	
	/**
	 * Metodo usado para añadir pociones recogidas al inventario del personaje y que estas se puedan usar
	 * 
	 * @param objeto , pasamos por argumento el objeto que vamos a recoger, en este caso pociones
	 */
	
	public void coge(ObjetoConNombre objeto) {
		inventario.add(objeto);
	}
	
	/**
	 * Metodo que nos sirve para que podamos saber cuantas pociones tenemos en nuestro inventario, recorremos el inventario con un bucle for
	 * y de esta manera sabremos cuantas pociones tenemos, en este caso de Mana
	 * 
	 * @return nos devuelve la cantidad de pociones de Mana en nuestro inventario
	 */
	
	public int cuantasPocionesMana() {
		int n = 0;
		
		for (int i = 0; i < inventario.size(); i++) {
			if (inventario.get(i) instanceof PocionMana) {
				n++;
			}
		}
		
		return n;
	}
	
	
	
	public PocionMana getPocionMana() {
		PocionMana pocion = null;
		
		int i = 0;
		
		while ((i < inventario.size()) && !(inventario.get(i) instanceof PocionMana)) {
			i++;
		}
		
		if (i < inventario.size()) {
			pocion = (PocionMana) inventario.get(i);
		}
		
		return pocion;
	}
	
	public PocionVida getPocionVida() {
		PocionVida pocion = null;
		
		int i = 0;
		
		while ((i < inventario.size()) && !(inventario.get(i) instanceof PocionVida)) {
			i++;
		}
		
		if (i < inventario.size()) {
			pocion = (PocionVida) inventario.get(i);
		}
		
		return pocion;
	}
	
	/**
	 * Metodo que nos sirve para que podamos saber cuantas pociones tenemos en nuestro inventario, recorremos el inventario con un bucle for
	 * y de esta manera sabremos cuantas pociones tenemos, en este caso de Vida
	 * 
	 * @return nos devuelve la cantidad de pociones de Vida en nuestro inventario
	 */
	
	public int cuantasPocionesVida() {
        int n = 0;
		
		for (int i = 0; i < inventario.size(); i++) {
			if (inventario.get(i) instanceof PocionVida) {
				n++;
			}
		}
		
		return n;
	}
	
	
	/**
	 * Metodo usado para determinar la cantidad de vida recuperada, tenemos en cuenta la cantidad maxima de vida para no escederla,
	 * en el momento que la excedemos, la igualamos a su vida maxima
	 * 
	 * @param recupera vida recuperada
	 */
	
	public void recuperaVida(int recupera) {
		vida += recupera;
		
		if (vida > maxVida) {
			vida = maxVida;
		}
	}
	
	/**
	 * Metodo usado para eliminar las pociones de nuestro inventario
	 * 
	 * @param objeto pasamos por argumento el objeto que usa el personaje en combate
	 */
	public void quitaObjeto(ObjetoConNombre objeto) {
		inventario.remove(objeto);
	}

	@Override
	public String toString() {
		String resultado = "Nombre: " + getNombre() + "\nVida: " + vida + "\nAtaque: " + ataque + "\nDefensa: " + defensa + "\nInventario:\n";
		
        for (int i = 0; i < inventario.size(); i++) {
			resultado += inventario.get(i) + "\n";
		}
		
		return resultado;
	}
}
