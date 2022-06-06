package dyc;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dyc.clases.Sesion;
import dyc.gui.VentanaFrame;

public class Main {

	public static void main(String[] args) {
		VentanaFrame v;
		Sesion sesion;

		try {
			sesion = new Sesion(); 
			v = new VentanaFrame(sesion);
			v.setVisible(true);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

}
