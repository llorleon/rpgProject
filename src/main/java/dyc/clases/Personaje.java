package dyc.clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Personaje extends ObjetoConNombre {
	private int vida;
	private int ataque;
	private int defensa;
	private List<ObjetoConNombre> inventario = new ArrayList<ObjetoConNombre>();

	public Personaje(String nombre, int vida, int ataque, int defensa, List<ObjetoConNombre> inventario)
			throws SQLException {
		super(nombre);
		this.vida = vida;
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

	@Override
	public String toString() {
		String resultado = "Nombre: " + getNombre() + "\nVida: " + vida + "\nAtaque: " + ataque + "\nDefensa: " + defensa + "\nInventario:\n";
		
        for (int i = 0; i < inventario.size(); i++) {
			resultado += inventario.get(i) + "\n";
		}
		
		return resultado;
	}
}
