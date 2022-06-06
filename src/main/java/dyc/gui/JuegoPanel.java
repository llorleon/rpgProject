package dyc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import dyc.clases.Sesion;

public class JuegoPanel extends JPanel {
	private static final long serialVersionUID = -8510474658317474918L;

	public JuegoPanel(VentanaFrame v, Sesion sesion) {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		setVisible(true);
	}

}
