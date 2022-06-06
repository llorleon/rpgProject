package dyc.gui;


import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dyc.clases.Sesion;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaJuego extends JPanel {

	private static final long serialVersionUID = 4094030091183746399L;

	public VentanaJuego(Ventana v, Sesion sesion) {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		JLabel lblHasElegidoLa = new JLabel("Has elegido la clase:");
		lblHasElegidoLa.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblHasElegidoLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasElegidoLa.setForeground(Color.GREEN);
		
		add(lblHasElegidoLa, BorderLayout.NORTH);
		
		setVisible(true);
	}
}
