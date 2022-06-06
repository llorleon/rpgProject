package dyc.gui;


import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dyc.clases.Sesion;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class ResumenPanel extends JPanel {

	private static final long serialVersionUID = 4094030091183746399L;

	public ResumenPanel(VentanaFrame v, Sesion sesion) {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		JLabel lblHasElegidoLa = new JLabel("Has elegido la clase:");
		lblHasElegidoLa.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblHasElegidoLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasElegidoLa.setForeground(Color.GREEN);
		
		add(lblHasElegidoLa, BorderLayout.NORTH);
		
		JTextArea textClase = new JTextArea();
		textClase.setForeground(Color.GREEN);
		textClase.setBackground(Color.BLACK);
		textClase.setEditable(false);
		add(textClase, BorderLayout.CENTER);
		textClase.setText(sesion.getPersonaje().toString());
		
		JButton empezarButton = new JButton("Empezar");
		empezarButton.setBackground(Color.GRAY);
		empezarButton.setForeground(Color.GREEN);
		add(empezarButton, BorderLayout.SOUTH);
		
		empezarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiaPantalla(new JuegoPanel(v, sesion));
			}
		});
		
		setVisible(true);
	}
}
