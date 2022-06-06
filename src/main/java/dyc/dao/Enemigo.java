package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import dyc.db.ConexionBD;
import dyc.exception.EnemigoException;

public class Enemigo {
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;

	public Enemigo() throws SQLException, EnemigoException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from enemigo ORDER BY RAND() LIMIT 1");
		
		if (cursor.next()) {
			this.nombre = cursor.getString("nombre");
			this.vida = cursor.getInt("vida");
			this.ataque = cursor.getInt("ataque");
			this.defensa = cursor.getInt("defensa");
		} else {
			throw new EnemigoException("No hay enemigos en la base de datos");
		}

		ConexionBD.desconectar();
	}
	
	public static Enemigo generaEnemigo() throws SQLException, EnemigoException {
		Enemigo enemigo;
		Random random = new Random(); 
		
		if (random.nextBoolean() == true) {
		    enemigo = new Enemigo();
		} else {
			enemigo = null;
		}
		
		return enemigo;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void restaVida(int vida) {
		this.vida -= vida;
	}

	@Override
	public String toString() {
		return nombre+" con salud de: "+vida+" Ataque: "+ataque+" Defensa: "+defensa;
	}

}
