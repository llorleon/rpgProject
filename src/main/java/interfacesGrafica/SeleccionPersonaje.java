package interfacesGrafica;

import javax.swing.JPanel;

import interfacesGrafica.Ventana;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.Mapa;
import clases.Personaje;
import clasesDAO.Arquero;
import clasesDAO.Guerrero;
import clasesDAO.Mago;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class SeleccionPersonaje extends JPanel {

	private Ventana ventana;

	public SeleccionPersonaje(Ventana v) throws SQLException {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 450, 0 };
		gridBagLayout.rowHeights = new int[] { 16, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel titulo = new JLabel("Bienvenido a Dungeons & Goblins, elija su clase:\n");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.anchor = GridBagConstraints.NORTH;
		gbc_titulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 2;
		add(titulo, gbc_titulo);

		JButton guerrero = new JButton("Guerrero");
		guerrero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mapa mapa;
				try {
					Guerrero guerrero = new Guerrero();

					mapa = new Mapa();
					System.out.println(mapa);
					System.out.println(guerrero);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_guerrero = new GridBagConstraints();
		gbc_guerrero.insets = new Insets(0, 0, 5, 0);
		gbc_guerrero.gridx = 0;
		gbc_guerrero.gridy = 4;
		add(guerrero, gbc_guerrero);

		JButton arquero = new JButton("Arquero");
		arquero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Mapa mapa = new Mapa();
					Arquero arquero = new Arquero();

					System.out.println(arquero);
					System.out.println(mapa);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_arquero = new GridBagConstraints();
		gbc_arquero.insets = new Insets(0, 0, 5, 0);
		gbc_arquero.gridx = 0;
		gbc_arquero.gridy = 6;
		add(arquero, gbc_arquero);

		JButton mago = new JButton("Mago");
		mago.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Mapa mapa = new Mapa();
					Mago mago = new Mago();

					System.out.println(mago);
					System.out.println(mapa);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_mago = new GridBagConstraints();
		gbc_mago.gridx = 0;
		gbc_mago.gridy = 8;
		add(mago, gbc_mago);

	}

}
