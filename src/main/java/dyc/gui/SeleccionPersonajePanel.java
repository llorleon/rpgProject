package dyc.gui;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dyc.clases.Sesion;
import dyc.dao.Arquero;
import dyc.dao.Guerrero;
import dyc.dao.Mago;
import dyc.exception.ClaseException;
import dyc.exception.EnemigoException;
import dyc.exception.ObjetosException;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;

public class SeleccionPersonajePanel extends JPanel {

	private static final long serialVersionUID = -6371461512707126474L;

	public SeleccionPersonajePanel(VentanaFrame v, Sesion sesion) throws SQLException {
		setBackground(Color.BLACK);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 450, 0 };
		gridBagLayout.rowHeights = new int[] { 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel titulo = new JLabel("Bienvenido a Dungeons & Goblins, elija su clase:\n");
		titulo.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		titulo.setForeground(Color.GREEN);
		titulo.setBackground(Color.BLACK);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.anchor = GridBagConstraints.NORTH;
		gbc_titulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_titulo.gridx = 2;
		gbc_titulo.gridy = 2;
		add(titulo, gbc_titulo);

		/**
		 * Boton que desencadena la seleccion del mago en la partida
		 */
		JButton mago_1 = new JButton("Mago");
		mago_1.setForeground(Color.GREEN);
		mago_1.setBackground(Color.BLACK);
		mago_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Mago mago = new Mago();
					sesion.setPersonaje(mago);

					System.out.println(mago);
					v.cambiaPantalla(new ResumenPanel(v, sesion));
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (EnemigoException ee) {
					ee.printStackTrace();
				} catch (ClaseException e2) {
					// TODO: handle exception
					e2.printStackTrace();

				} catch (ObjetosException e3) {
					// TODO: handle exception
					e3.printStackTrace();

				}

			}
		});

		/**
		 * Boton que desencadena la creacion del Arquero en la partida
		 */
		JButton arquero_1 = new JButton("Arquero");
		arquero_1.setForeground(Color.GREEN);
		arquero_1.setBackground(Color.BLACK);
		arquero_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Arquero arquero = new Arquero();
					sesion.setPersonaje(arquero);

					System.out.println(arquero);
					v.cambiaPantalla(new ResumenPanel(v, sesion));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EnemigoException ee) {
					ee.printStackTrace();
				} catch (ClaseException e2) {
					// TODO: handle exception
					e2.printStackTrace();

				} catch (ObjetosException e3) {
					// TODO: handle exception
					e3.printStackTrace();

				}
			}
		});

		/**
		 * Boton que desencadena la creacion del guerrero en la partida
		 */
		JButton guerrero_1 = new JButton("Guerrero");
		guerrero_1.setForeground(Color.GREEN);
		guerrero_1.setBackground(Color.BLACK);
		guerrero_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Guerrero guerrero = new Guerrero();
					sesion.setPersonaje(guerrero);

					System.out.println(guerrero);
					v.cambiaPantalla(new ResumenPanel(v, sesion));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EnemigoException ee) {
					ee.printStackTrace();
				} catch (ClaseException e2) {
					// TODO: handle exception
					e2.printStackTrace();

				} catch (ObjetosException e3) {
					// TODO: handle exception
					e3.printStackTrace();

				}

			}
		});
		
		/**
		 * Boton para que nos lleve a al Panel de ver el log de la partida
		 */
		JButton ultimoLogButton = new JButton("Log última partida");
		ultimoLogButton.setForeground(Color.GREEN);
		ultimoLogButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiaPantalla(new LogPanel(v, SeleccionPersonajePanel.this));
			}
		});
		
		
		GridBagConstraints gbc_ultimoLogButton = new GridBagConstraints();
		gbc_ultimoLogButton.insets = new Insets(0, 0, 5, 0);
		gbc_ultimoLogButton.gridx = 2;
		gbc_ultimoLogButton.gridy = 5;
		add(ultimoLogButton, gbc_ultimoLogButton);
		GridBagConstraints gbc_guerrero_1 = new GridBagConstraints();
		gbc_guerrero_1.insets = new Insets(0, 0, 5, 0);
		gbc_guerrero_1.gridx = 2;
		gbc_guerrero_1.gridy = 7;
		add(guerrero_1, gbc_guerrero_1);
		GridBagConstraints gbc_arquero_1 = new GridBagConstraints();
		gbc_arquero_1.insets = new Insets(0, 0, 5, 0);
		gbc_arquero_1.gridx = 2;
		gbc_arquero_1.gridy = 8;
		add(arquero_1, gbc_arquero_1);
		GridBagConstraints gbc_mago_1 = new GridBagConstraints();
		gbc_mago_1.gridx = 2;
		gbc_mago_1.gridy = 9;
		add(mago_1, gbc_mago_1);

	}

}
