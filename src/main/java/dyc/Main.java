package dyc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dyc.clases.Lugar;
import dyc.clases.Mapa;
import dyc.clases.ObjetoConNombre;
import dyc.clases.Personaje;
import dyc.dao.Arma;
import dyc.dao.Enemigo;
import dyc.dao.Guerrero;
import dyc.dao.Mago;
import dyc.dao.ObjetoDefensivo;
import dyc.dao.PocionMana;
import dyc.dao.PocionVida;
import dyc.gui.Ventana;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Ventana v = new Ventana();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
