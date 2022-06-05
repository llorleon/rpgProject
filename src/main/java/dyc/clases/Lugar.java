package dyc.clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dyc.dao.Enemigo;
import dyc.db.ConexionBD;

public class Lugar {
	private String nombreLugar;
	Enemigo enemigo = new Enemigo();
	

	public Lugar(String nombreLugar) throws SQLException {
		super();

	}

	public Lugar() throws SQLException {

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from lugares ORDER BY RAND() LIMIT 1");
		if (cursor.next()) {

			this.nombreLugar = cursor.getString("nombre");
		}

		// TODO Auto-generated catch block
		ConexionBD.desconectar();
	}

	public List LugarRandom() throws SQLException {

		List lugarcitos = new ArrayList();

		for (int i = 0; i < 10; i++) {

			Lugar lugarRandom = new Lugar();

			lugarRandom.toString();
			if (!lugarcitos.contains(lugarRandom.toString())) {

				lugarcitos.add(lugarRandom);

			}

		}
		return lugarcitos;
	}

	public String getNombreLugar() {
		return nombreLugar;
	}

	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}

	@Override
	public String toString() {
		return nombreLugar;
	}

}
