package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Lugar;
import clases.Mapa;
import clases.ObjetoConNombre;
import clases.Personaje;
import clasesDAO.Arma;
import clasesDAO.Enemigo;
import clasesDAO.Mago;
import clasesDAO.ObjetoDefensivo;
import clasesDAO.PocionMana;
import clasesDAO.PocionVida;
import interfacesGrafica.Ventana;

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
