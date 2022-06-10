package dyc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

import dyc.clases.Personaje;
import dyc.clases.Sesion;
import dyc.dao.Enemigo;
import dyc.dao.Hechizo;
import dyc.dao.Mago;
import dyc.dao.PocionMana;
import dyc.dao.PocionVida;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.Font;

public class CombatePanel extends JPanel {
	private static final long serialVersionUID = -2126587181153509748L;

	private Sesion sesion;
	private JButton pocionVidaButton;
	private JButton pocionManaButton;
	private JTextArea textArea;
	private JPanel panel_1;
	private JLabel enemigoLabel;
	private JProgressBar enemigoBar;
	private Personaje personaje;
	private JPanel panel;
	private JPanel panel_2;
	private JButton atacarButton;
	private JButton hechizo1Button;
	private JButton hechizo2Button;
	private JPanel panel_3;
	private JProgressBar personajeBar;
	private JProgressBar manaBar;
	private Enemigo enemigo;
	private Random random;
	private boolean gameOver;
	private boolean enemigoDerrotado;
	private JButton salirButton;
	private JButton continuarButton;
	private JScrollPane scrollPane;
	private JuegoPanel juego;
	
	/**
	 * Metodo para iniciar el combate 
	 * @param v ventana del JFrame
	 * @param sesion llamamos a la partida
	 * @param juego y llamamos al JPanel de Juego para volver sin problema y continuar por donde lo dejamos
	 */
	public CombatePanel(VentanaFrame v, Sesion sesion, JuegoPanel juego) {
		this.sesion = sesion;
		
		this.juego = juego;
		gameOver = false;
		enemigoDerrotado = false;
		
		random = new Random();
		
		personaje = sesion.getPersonaje();
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		enemigoLabel = new JLabel();
		enemigoLabel.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		enemigoLabel.setForeground(Color.GREEN);
		panel_1.add(enemigoLabel);
		
		enemigoBar = new JProgressBar();
		enemigoBar.setForeground(Color.RED);
		panel_1.add(enemigoBar);
		
		/**
		 * Barra de vida del enemigo
		 */
		enemigo = sesion.getMapa().getLugar().getEnemigo();
		enemigoLabel.setText(enemigo.getNombre());
		enemigoBar.setMaximum(enemigo.getVida());
		enemigoBar.setValue(enemigo.getVida());
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3);
		
		/**
		 * Barra de vida de cualquier personaje (Amistoso)
		 */
		personajeBar = new JProgressBar();
		personajeBar.setForeground(Color.GREEN);
		panel_3.add(personajeBar);
		
		personajeBar.setMaximum(personaje.getMaxVida());
		personajeBar.setValue(personaje.getVida());
		
		/**
		 * Barra de mana del personaje Mago, recurso con el que lanza hechizos
		 */
		manaBar = new JProgressBar();
		manaBar.setForeground(Color.CYAN);
		panel_3.add(manaBar);
		
		if (personaje instanceof Mago) {
			Mago mago = (Mago) personaje;
			
			manaBar.setMaximum(mago.getMaxMana());
			manaBar.setValue(mago.getMana());
		}
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel.add(panel_2);
		
		atacarButton = new JButton("Atacar");
		atacarButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		atacarButton.setBackground(Color.GRAY);
		atacarButton.setForeground(Color.GREEN);
		panel_2.add(atacarButton);
		
		/**
		 * Boton usado para las clases de Arquero y Guerrero, con esta atacamos al enemigo 
		 */
		atacarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Daño generado aleatoriamente entre el daño del ataque base y el arma del personaje
				 */
				int danno = random.nextInt(personaje.getAtaque() + personaje.getArma().getPuntosAtaque() + 1);
				
				enemigo.restaVida(danno);
				enemigoBar.setValue(enemigo.getVida());
				
				textArea.append("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
				juego.logAppend("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
				
				enemigoAtaca();
			}
		});
		
		hechizo1Button = new JButton("Hechizo");
		hechizo1Button.setFont(new Font("Optima", Font.PLAIN, 13));
		hechizo1Button.setBackground(Color.GRAY);
		hechizo1Button.setForeground(Color.GREEN);
		panel_2.add(hechizo1Button);
		

		/**
		 * Primer hechizo que tiene el mago, al pursarlo haremos el daño establecido al enemigo
		 */
		hechizo1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Creamos un Mago
				 */
				Mago mago = (Mago) personaje;
				Random random = new Random();
				Hechizo hechizo = mago.getHechizo(hechizo1Button.getText());
				
				/**
				 * El hechizo se lanzara siempre y cuando el mana sea superior al costedemana del hechizo
				 */
				if (mago.getMana() >= hechizo.getCosteMana()) {
					int danno = random.nextInt(hechizo.getPuntosAtaque() + 1);
					
					mago.consumeMana(hechizo.getCosteMana());
					enemigo.restaVida(danno);
					enemigoBar.setValue(enemigo.getVida());
					manaBar.setValue(mago.getMana());
					
					textArea.append("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
					juego.logAppend("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
					
					enemigoAtaca();
					/**
					 * Si no tiene mana y tampoco tiene pociones de mana, el enemigo atacara y mucho me temo
					 * que has muerto...
					 */
				} else if (mago.getPocionMana() == null) {
					enemigoAtaca();
				}
			}
		});
		
		hechizo2Button = new JButton("New button");
		hechizo2Button.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		hechizo2Button.setBackground(Color.GRAY);
		hechizo2Button.setForeground(Color.GREEN);
		panel_2.add(hechizo2Button);
		
		/**
		 * Segundo hechizo que tiene el mago, al pursarlo haremos el daño establecido al enemigo
		 */
		hechizo2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Creamos un Mago
				 */
				Mago mago = (Mago) personaje;
				Random random = new Random();
				Hechizo hechizo = mago.getHechizo(hechizo2Button.getText());
				
				/**
				 * El hechizo se lanzara siempre y cuando el mana sea superior al costedemana del hechizo
				 */
				if (mago.getMana() >= hechizo.getCosteMana()) {
					int danno = random.nextInt(hechizo.getPuntosAtaque() + 1);
					
					mago.consumeMana(hechizo.getCosteMana());
					enemigo.restaVida(danno);
					enemigoBar.setValue(enemigo.getVida());
					manaBar.setValue(mago.getMana());
					
					textArea.append("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
					juego.logAppend("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
					
					enemigoAtaca();
					/**
					 * Si no tiene mana y tampoco tiene pociones de mana, el enemigo atacara y mucho me temo
					 * que has muerto...
					 */
				} else if (mago.getPocionMana() == null) {
					enemigoAtaca();
				}
			}
		});
		
		pocionVidaButton = new JButton("Poción vida");
		pocionVidaButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		pocionVidaButton.setBackground(Color.GRAY);
		pocionVidaButton.setForeground(Color.GREEN);
		
		panel_2.add(pocionVidaButton);
		
		/**
		 * Boton que desencadena el uso de la pocion de vida
		 */
		
		pocionVidaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Obtenemos el personaje de la partida
				 */
				Personaje personaje = sesion.getPersonaje();
				/**
				 * Obtenemos la pocion que vamos a usar
				 */
				PocionVida pocion = personaje.getPocionVida();
				/**
				 * La cantidad de vida que se recupera
				 */
				int recupera = pocion.getVidaRecuperada();
				
				textArea.append("Te bebes " + pocion.getNombre() + " y recuperas " + recupera + " vida\n");
				juego.logAppend("Te bebes " + pocion.getNombre() + " y recuperas " + recupera + " vida\n");
				personaje.recuperaVida(recupera);
				personajeBar.setValue(personaje.getVida());
				personaje.quitaObjeto(pocion);
				actualizaBotones();
				
				enemigoAtaca();
			}
		});
		
		continuarButton = new JButton("Continuar");
		continuarButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		continuarButton.setBackground(Color.BLACK);
		continuarButton.setForeground(Color.GREEN);
		panel_2.add(continuarButton);
		
		/**
		 * Boton para continuar la partida si has salido victorioso del combate
		 */
		
		continuarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				juego.actualizaBotones();
				v.cambiaPantalla(juego);
			}
		});
		
		salirButton = new JButton("Salir");
		salirButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		salirButton.setBackground(Color.BLACK);
		salirButton.setForeground(Color.GREEN);
		panel_2.add(salirButton);
		
		/**
		 * Boton para salir de la partida si has muerto
		 */
		
		salirButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		pocionManaButton = new JButton("Poción maná");
		pocionManaButton.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		pocionManaButton.setForeground(Color.GREEN);
		panel_2.add(pocionManaButton);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Hoefler Text", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		
		pocionManaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mago personaje = (Mago) sesion.getPersonaje();
				PocionMana pocion = personaje.getPocionMana();
				int recupera = pocion.getManaRecuperada();
				
				textArea.append("Te bebes " + pocion.getNombre() + " y recuperas " + recupera + " maná\n");
				juego.logAppend("Te bebes " + pocion.getNombre() + " y recuperas " + recupera + " maná\n");
				
				personaje.recuperaMana(recupera);
				manaBar.setValue(personaje.getMana());
				personaje.quitaObjeto(pocion);
				actualizaBotones();
				
				enemigoAtaca();
			}
		});

		actualizaBotones();
	}
	
	/**
	 * Metodo usado para crear el bucle de daño en el que el enemigo ataca cuando el personaje ataca, siempre despuesde del ataque 
	 * del personaje
	 * Esto ocurrirar siempre que el enemigo este vivo, si muere se acaba el combate o si el personaje no esta vivo, se acaba la partida
	 * porque estas MUERTO :(
	 */
	
	public void enemigoAtaca() {
		if (enemigo.estaVivo()) {
			/**
			 * Daño aleatorio del enemigo
			 */
			int danno = random.nextInt(enemigo.getAtaque() + 1);
			
			personaje.restaVida(danno);
			personajeBar.setValue(personaje.getVida());
			
			textArea.append(enemigo.getNombre() + " hizo " + danno + " puntos de daño\n");
			juego.logAppend(enemigo.getNombre() + " hizo " + danno + " puntos de daño\n");
		    
		    if (!personaje.estaVivo()) {
		    	textArea.append("Has sido derrotado por " + enemigo.getNombre() + "\n");
		    	juego.logAppend("Has sido derrotado por " + enemigo.getNombre() + "\n");
		    	gameOver = true;
		    	actualizaBotones();
		    }
		} else {
			textArea.append(enemigo.getNombre() + " ha sido derrotado\n");
			juego.logAppend(enemigo.getNombre() + " ha sido derrotado\n");
			enemigoDerrotado = true;
			actualizaBotones();
		}
	}
	
	/**
	 * Metodo para actualizar los botones, es decir, para ponerlos visibles o no dependiendo de la situacion
	 * Si tienes pociones, si pierdes y mueres, si ganas y continuas...
	 */

	public void actualizaBotones() {
		int nPociones = personaje.cuantasPocionesMana();
		
		if (gameOver) {
            atacarButton.setVisible(false);
			hechizo1Button.setVisible(false);
			hechizo2Button.setVisible(false);
			pocionVidaButton.setVisible(false);
			pocionManaButton.setVisible(false);
			continuarButton.setVisible(false);
			salirButton.setVisible(true);
		} else if (enemigoDerrotado) {
			atacarButton.setVisible(false);
			hechizo1Button.setVisible(false);
			hechizo2Button.setVisible(false);
			pocionVidaButton.setVisible(false);
			pocionManaButton.setVisible(false);
			continuarButton.setVisible(true);
			salirButton.setVisible(false);
		} else {
			continuarButton.setVisible(false);
			salirButton.setVisible(false);
			
			/**
			 * Si el personaje es mago, activamos las opciones de hechizos
			 */
			if (personaje instanceof Mago) {
				Mago mago = (Mago) personaje;
				
				manaBar.setVisible(true);
				
				atacarButton.setVisible(false);
				
				hechizo1Button.setVisible(true);
				hechizo2Button.setVisible(true);
				
				/**
				 * Creamos un objeto array con los hechizos, de esta manera obtenemos su nombre y podemos hacer los botones de hechizo
				 * con su respectivo nombre
				 */
				Object[] hechizos = mago.getHechizos().toArray();
				
				hechizo1Button.setText(hechizos[0].toString());
				hechizo2Button.setText(hechizos[1].toString());
				
				if (nPociones > 0) {
					pocionManaButton.setText("Poción maná x" + nPociones);
					pocionManaButton.setVisible(true);
				} else {
					pocionManaButton.setVisible(false);
				}
			} else {
				manaBar.setVisible(false);
				atacarButton.setVisible(true);
				pocionManaButton.setVisible(false);
				hechizo1Button.setVisible(false);
				hechizo2Button.setVisible(false);
			}
	
			nPociones = sesion.getPersonaje().cuantasPocionesVida();
			
			if (nPociones > 0) {
				pocionVidaButton.setText("Poción vida x" + nPociones);
				pocionVidaButton.setVisible(true);
			} else {
				pocionVidaButton.setVisible(false);
			}
		}
	}
}
