package dyc.clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dyc.dao.PocionMana;
import dyc.dao.PocionVida;

public abstract class Personaje extends ObjetoConNombre {
	private int maxVida;
	private int vida;
	private int ataque;
	private int defensa;
	private List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();

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

	public void setInventario(List<ObjetoConNombre> inventario) {
		this.inventario = inventario;
	}
	
	public void coge(ObjetoConNombre objeto) {
		inventario.add(objeto);
	}
	
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
	
	public int cuantasPocionesVida() {
        int n = 0;
		
		for (int i = 0; i < inventario.size(); i++) {
			if (inventario.get(i) instanceof PocionVida) {
				n++;
			}
		}
		
		return n;
	}
	
	public void recuperaVida(int recupera) {
		vida += recupera;
		
		if (vida > maxVida) {
			vida = maxVida;
		}
	}
	
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
