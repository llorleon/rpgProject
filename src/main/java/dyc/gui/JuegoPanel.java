package dyc.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dyc.clases.Sesion;
import dyc.dao.Enemigo;
import dyc.dao.Lugar;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JScrollPane;
import java.awt.Font;

public class JuegoPanel extends JPanel {
	private static final long serialVersionUID = -8510474658317474918L;
	
	private Sesion sesion;
	private JTextArea textArea;
	private JButton atacarButton;
	private JButton huirButton;
	private JButton recogerButton;
	private JButton siguienteButton;
	private JScrollPane scrollPane;
	private JButton salirButton;

	public JuegoPanel(VentanaFrame v, Sesion sesion) {
		this.sesion = sesion;
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		atacarButton = new JButton("Atacar");
		atacarButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		atacarButton.setBackground(Color.GRAY);
		atacarButton.setForeground(Color.GREEN);
		panel.add(atacarButton);
		
		/**
		 * Boton que inicia el combate, llamamos a ventana y cambiapantalla para crear un CombatePanel
		 */
		atacarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiaPantalla(new CombatePanel(v, sesion, JuegoPanel.this));
			}
		});
		
        siguienteButton = new JButton("Siguiente");
        siguienteButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
        siguienteButton.setBackground(Color.GRAY);
		siguienteButton.setForeground(Color.GREEN);
		panel.add(siguienteButton);
		
		/**
		 * Boton para avanzar en la aventura, pasamos a la siguiente zona
		 */
		siguienteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sesion.getMapa().avanzaLugar();
				actualizaLugar();
				actualizaBotones();
			}
		});
		
		huirButton = new JButton("Huir");
		huirButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		huirButton.setBackground(Color.GRAY);
		huirButton.setForeground(Color.GREEN);
		panel.add(huirButton);
		
		/**
		 * Boton con un random del 50%, si funciona podremos continuar, sino, solo nos dara la opcion a combatir
		 */
		huirButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random random = new Random();
				
				if (random.nextBoolean() == true) {
					sesion.getMapa().avanzaLugar();
					actualizaLugar();
					actualizaBotones();
				} else {
					huirButton.setVisible(false);
					textArea.append("No has podido huir, tienes que luchar\n");
					logAppend("No has podido huir, tienes que luchar\n");
				}
			}
		});
		
		recogerButton = new JButton("Recoger");
		recogerButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		recogerButton.setBackground(Color.GRAY);
		recogerButton.setForeground(Color.GREEN);
		panel.add(recogerButton);
		
		salirButton = new JButton("Salir");
		salirButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		salirButton.setBackground(Color.BLACK);
		salirButton.setForeground(Color.GREEN);
		panel.add(salirButton);
		
		/**
		 * Boton usado para salir de la partida
		 */
		salirButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		textArea.setLineWrap(true);
		
		/**
		 * Boton usado para recoger pociones
		 */
		recogerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.append("Has cogido " + sesion.getMapa().getLugar().getPocion().getNombre() + "\n");
				logAppend("Has cogido " + sesion.getMapa().getLugar().getPocion().getNombre() + "\n");
				sesion.getPersonaje().coge(sesion.getMapa().getLugar().getPocion());
				sesion.getMapa().getLugar().setPocion(null);
				actualizaBotones();
			}
		});
		
		setVisible(true);
		
		actualizaLugar();
		actualizaBotones();
	}
	
	/**
	 * Metodo usado para avanzar de lugar, usamos el append para que todo el log vaya escribiendose
	 */
	public void actualizaLugar() {
		if (!sesion.getMapa().juegoTerminado()) {
		    textArea.append(sesion.getMapa().getLugar().toString() + "\n");
		    logAppend(sesion.getMapa().getLugar().toString() + "\n");
		} else {
			textArea.append("Has terminado el juego!\n");
			logAppend("Has terminado el juego!\n");
		}
	}
	
	/**
	 * Metodo para actualizar los botones, es decir, para ponerlos visibles o no dependiendo de la situacion
	 * Si tienes pociones, si pierdes y mueres, si ganas y continuas...
	 */
	
	public void actualizaBotones() {
		if (!sesion.getMapa().juegoTerminado()) {
			salirButton.setVisible(false);
			
			Lugar lugar = sesion.getMapa().getLugar();
			Enemigo enemigo = lugar.getEnemigo();
			
			/**
			 * Si hay un enemigo, podremos atacar o Huir con un 50% de prob
			 */
			if (enemigo != null && enemigo.estaVivo()) {
				atacarButton.setVisible(true);
				huirButton.setVisible(true);
				recogerButton.setVisible(false);
				siguienteButton.setVisible(false);
			}
			/**
			 * Si hay una pocion podremos recogerla
			 */
			else if (lugar.getPocion() != null) {
				atacarButton.setVisible(false);
				huirButton.setVisible(false);
				recogerButton.setVisible(true);
				siguienteButton.setVisible(true);
			} 
			/**
			 * Si no ocurre nada podremos continuar al siguiente evento
			 */
			else {
				atacarButton.setVisible(false);
				huirButton.setVisible(false);
				recogerButton.setVisible(false);
				siguienteButton.setVisible(true);
			}
		} 
		/**
		 * Sino la partida habra terminado y podremos salir
		 */
		else {
			atacarButton.setVisible(false);
			huirButton.setVisible(false);
			recogerButton.setVisible(false);
			siguienteButton.setVisible(false);
			salirButton.setVisible(true);
		}
	}
	
	/**
	 * Metodo usado para basicamente escribir el log de la partida, cremos el filewriter y damos la ruta del archivo que vamos a escribir
	 * @param linea el texto que insertaremos en cada linea
	 */
	public void logAppend(String linea) {
		try {
			FileWriter fw = new FileWriter("log.txt", true);
			fw.write(linea);
			fw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
