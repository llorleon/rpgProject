package dyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.db.ConexionBD;

public class Enemigo {

	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;

	public Enemigo(String nombre, int vida, int ataque, int defensa) throws SQLException {
		this.nombre=nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
	}

	public Enemigo() throws SQLException {

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from enemigo ORDER BY RAND() LIMIT 1");
		if (cursor.next()) {

			this.nombre = cursor.getString("nombre");
			this.vida = cursor.getInt("vida");
			this.ataque = cursor.getInt("ataque");
			this.defensa = cursor.getInt("defensa");

		}

		// TODO Auto-generated catch block
		ConexionBD.desconectar();

	}

	public List EnemigoRandom() throws SQLException {

		List enemiguitos = new ArrayList();

		for (int i = 0; i < 6; i++) {

			Enemigo enemigoRandom = new Enemigo();

			enemigoRandom.toString();
			if (!enemiguitos.contains(enemigoRandom.toString())) {

				enemiguitos.add(enemigoRandom);

			}

		}
		return enemiguitos;
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

	@Override
	public String toString() {
		return nombre+" con salud de: "+vida+" Ataque: "+ataque+" Defensa: "+defensa;
	}

}
