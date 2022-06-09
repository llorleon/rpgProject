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

public class LogPanel extends JPanel {

	private static final long serialVersionUID = 92297959709232624L;

	public LogPanel(VentanaFrame v, SeleccionPersonajePanel seleccionPersonaje) {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("En la anterior partida...");
		lblNewLabel.setForeground(Color.GREEN);
		add(lblNewLabel, BorderLayout.NORTH);

		JButton volverButton = new JButton("Volver");
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
		scrollPane.setViewportView(textArea);

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
