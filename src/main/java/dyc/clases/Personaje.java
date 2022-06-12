package dyc.clases;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dyc.dao.Arma;
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
	
	/**
	 * maxVida sera usado para determinar la vida maxima del personaje y de esta manera que sea inamomible con pociones
	 */
	private int maxVida;
	
	/**
	 * vida es la vida que tiene el personaje en la bbdd
	 */
	private int vida;
	/**
	 * ataque base del personaje
	 */
	private int ataque;
	/**
	 * defensa base del personaje
	 */
	private int defensa;
	
	/**
	 * Coleccion que nos sirve para almacenar en el inventario del personaje, armas, pociones, objetosdefensivos...
	 */
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

	/**
	 * Metodo sin argumentos para llamar facilmente a la clase personaje
	 */
	public Personaje() {
		
	}
	
	/**
	 * Getter para tomar la vida de un personaje
	 * @return devuelve un entero de la vida del personaje
	 */
	
	public int getVida() {
		return vida;
	}

	/**
	 * Setter para establecer la vida del personaje
	 * 
	 * @param vida Sera la vida establecida en el personaje
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Obtener la vida maxima del personaje
	 * @return devuelve la vida maxima del peronsaje
	 */
	public int getMaxVida() {
		return maxVida;
	}

	/**
	 * Establecemos la vida maxima del peronsaje
	 * 
	 * @param maxVida la vida maxima que tendra el personjae
	 */
	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}

	/**
	 * Ataque base del personaje sin tener en cuenta el del arma
	 * @return se devuelve el ataque del perseonaje
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Establecemos el ataque del personaje
	 * 
	 * @param ataque entero que establece el daño base del personaje
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Obtenemos la estadistica defensa del personaje
	 * @return devuelve la cantidad de defensa
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Establecemos la defensa del personaje
	 * @param defensa el entero que establece la defensa del personaje
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Obtenemos todos los objetos añadidos en el inventario del personaje
	 * 
	 * @return devuelve la lista de objetos
	 */
	
	public List<ObjetoConNombre> getInventario() {
		return inventario;
	}
/**
 * Metodo con el que asignamos un objeto al inventario del personaje
 * 
 * @param inventario de inventario al que añadiremos los objetos en cada clase, mago, guerrero, arquero...
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
	
	/**
	 * Metodo usado para recuperar las pociones que tiene el personaje en su inventario
	 * @return devuelve las pociones que tiene el personaje
	 */
	
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
	
	/**
	 * Metodo usado para recuperar las pociones que tiene el personaje en su inventario
	 * @return devuelve las pociones que tiene el personaje
	 */
	
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

	/**
	 * Con este toString, recorremos las stats del Personaje y ademas añadimos los objetos a su inventario para la impresion por pantalla o 
	 * JSwing
	 * 
	 */
	@Override
	public String toString() {
		String resultado = "Nombre: " + getNombre() + "\nVida: " + vida + "\nAtaque: " + ataque + "\nDefensa: " + defensa + "\nInventario:\n";
		
        for (int i = 0; i < inventario.size(); i++) {
			resultado += inventario.get(i) + "\n";
		}
		
		return resultado;
	}
	
	/**
	 * Getter para obtener el arma que tiene asignada el personaje en su inventario
	 * 
	 * @return devuelve el arma que tiene el personaje en su inventario
	 */
	
	public Arma getArma() {
		Arma arma = null;
		
		for (int i = 0; i < inventario.size(); i++) {
			if (inventario.get(i) instanceof Arma) {
				arma = (Arma) inventario.get(i); 
			}
		}
		
		return arma;
	}
	
	/**
	 * Metodo usado para determinar si el personaje esta vivo o on
	 * @return devuelte true o false dependiendo de la vida del personaje
	 */
	
	public boolean estaVivo() {
		return vida > 0;
	}
	
	/**
	 * Metodo usado para el combate, actualiza la vida del personaje
	 * 
	 * @param vida es la vida que devuelve tras cualquier accion de combate
	 */
	
	public void restaVida(int vida) {
		this.vida -= vida;
	}
}
