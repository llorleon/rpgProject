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
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * Panel previo a empezar la partida, en este se mostrara las stats del personaje escogido y su inventario
 * @author victorml
 *
 */
public class ResumenPanel extends JPanel {

	private static final long serialVersionUID = 4094030091183746399L;

	/**
	 * Constructor del ResumenPanel con una Frame y la sesion, para obtener los datos del personaje
	 * @param v
	 * @param sesion
	 */
	public ResumenPanel(VentanaFrame v, Sesion sesion) {
		
		/**
		 * Escribimos en el log 
		 */
		try {
			FileWriter fw = new FileWriter("log.txt");
			fw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		JLabel lblHasElegidoLa = new JLabel("Has elegido la clase:");
		lblHasElegidoLa.setFont(new Font("Hoefler Text", Font.PLAIN, 26));
		lblHasElegidoLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasElegidoLa.setForeground(Color.GREEN);
		
		add(lblHasElegidoLa, BorderLayout.NORTH);
		
		JTextArea textClase = new JTextArea();
		textClase.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		textClase.setForeground(Color.GREEN);
		textClase.setBackground(Color.BLACK);
		textClase.setEditable(false);
		add(textClase, BorderLayout.CENTER);
		textClase.setText(sesion.getPersonaje().toString());
		
		JButton empezarButton = new JButton("Empezar");
		empezarButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		empezarButton.setBackground(Color.GRAY);
		empezarButton.setForeground(Color.GREEN);
		add(empezarButton, BorderLayout.SOUTH);
		
		/**
		 * Boton para empezar la partida una vez visto el personaje escogido
		 */
		empezarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiaPantalla(new JuegoPanel(v, sesion));
			}
		});
		
		setVisible(true);
	}
}
