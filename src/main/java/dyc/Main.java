package dyc;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dyc.clases.Sesion;
import dyc.gui.Ventana;

public class Main {

	public static void main(String[] args) {
		Ventana v;
		Sesion sesion;

		try {
			sesion = new Sesion(); 
			v = new Ventana(sesion);
			v.setVisible(true);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

}
