package dyc.gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

/**
 * Panel en el que basicamente leemos el archivo log de la ultima partida
 * @author victorml
 *
 */
public class LogPanel extends JPanel {

	private static final long serialVersionUID = 92297959709232624L;

	public LogPanel(VentanaFrame v, SeleccionPersonajePanel seleccionPersonaje) {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("En la anterior partida...");
		lblNewLabel.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.GREEN);
		add(lblNewLabel, BorderLayout.NORTH);

		/**
		 * Boton para volver de nuevo a la seleccion de personaje
		 */
		JButton volverButton = new JButton("Volver");
		volverButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		volverButton.setBackground(Color.GRAY);
		volverButton.setForeground(Color.GREEN);
		add(volverButton, BorderLayout.SOUTH);

		volverButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiaPantalla(seleccionPersonaje);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		scrollPane.setViewportView(textArea);

		/**
		 * Filereader y BufferedReader para leer el log y que lo saquemos en el texArea
		 */
		try {
			FileReader fr = new FileReader("log.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {
				textArea.append(linea + "\n");
			}

			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
