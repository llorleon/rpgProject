package dyc.gui;


import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dyc.clases.Sesion;

public class VentanaJuego extends JPanel {

	private static final long serialVersionUID = 4094030091183746399L;

	public VentanaJuego(Ventana v, Sesion sesion) {
		setBackground(new Color(255, 0,0 ));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel label = new JLabel("aqui el texto");
		
		add(label);
		
		setVisible(true);
	}
}
