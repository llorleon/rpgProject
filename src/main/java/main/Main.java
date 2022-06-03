package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import clases.ObjetoConNombre;
import clasesDAO.Arma;
import clasesDAO.ObjetoDefensivo;
import clasesDAO.PocionMana;
import clasesDAO.PocionVida;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Arma espada = new Arma("Espada de Madera");
			System.out.println(espada);
			
			ObjetoDefensivo armaduraTela = new ObjetoDefensivo("Saco de Harina");
			System.out.println(armaduraTela);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
