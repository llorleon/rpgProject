package dyc;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dyc.gui.Ventana;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Ventana v = new Ventana();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

}
