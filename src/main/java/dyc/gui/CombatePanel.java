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

public class CombatePanel extends JPanel {
	private static final long serialVersionUID = -2126587181153509748L;

	private Sesion sesion;
	private JButton pocionVidaButton;
	private JButton pocionManaButton;
	private JTextArea textArea;
	private JPanel panel_1;
	private JLabel enemigoLabel;
	private JProgressBar enemigoBar;
	private JLabel label;
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
	
	public CombatePanel(VentanaFrame v, Sesion sesion, JuegoPanel juego) {
		this.sesion = sesion;
		
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
		enemigoLabel.setForeground(Color.GREEN);
		panel_1.add(enemigoLabel);
		
		enemigoBar = new JProgressBar();
		panel_1.add(enemigoBar);
		
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
		
		personajeBar = new JProgressBar();
		panel_3.add(personajeBar);
		
		personajeBar.setMaximum(personaje.getMaxVida());
		personajeBar.setValue(personaje.getVida());
		
		manaBar = new JProgressBar();
		panel_3.add(manaBar);
		
		if (personaje instanceof Mago) {
			Mago mago = (Mago) personaje;
			
			manaBar.setMaximum(mago.getMaxMana());
			manaBar.setValue(mago.getMana());
		}
		
		label = new JLabel("New label");
		panel_1.add(label);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		add(textArea, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel.add(panel_2);
		
		atacarButton = new JButton("Atacar");
		atacarButton.setForeground(Color.GREEN);
		panel_2.add(atacarButton);
		
		atacarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int danno = random.nextInt(personaje.getAtaque() + personaje.getArma().getPuntosAtaque());
				
				enemigo.restaVida(danno);
				enemigoBar.setValue(enemigo.getVida());
				
				textArea.append("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
				
				enemigoAtaca();
			}
		});
		
		hechizo1Button = new JButton("Hechizo");
		hechizo1Button.setForeground(Color.GREEN);
		panel_2.add(hechizo1Button);
		
		hechizo1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mago mago = (Mago) personaje;
				Random random = new Random();
				Hechizo hechizo = mago.getHechizo(hechizo1Button.getText());
				int danno = random.nextInt(hechizo.getPuntosAtaque());
				
				mago.consumeMana(hechizo.getCosteMana());
				enemigo.restaVida(danno);
				enemigoBar.setValue(enemigo.getVida());
				manaBar.setValue(mago.getMana());
				
				textArea.append("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
				
				enemigoAtaca();
			}
		});
		
		hechizo2Button = new JButton("New button");
		hechizo2Button.setForeground(Color.GREEN);
		panel_2.add(hechizo2Button);
		
		hechizo2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mago mago = (Mago) personaje;
				Random random = new Random();
				Hechizo hechizo = mago.getHechizo(hechizo2Button.getText());
				int danno = random.nextInt(hechizo.getPuntosAtaque());
				
				mago.consumeMana(hechizo.getCosteMana());
				enemigo.restaVida(danno);
				enemigoBar.setValue(enemigo.getVida());
				manaBar.setValue(mago.getMana());
				
				textArea.append("Le haces " + danno + " puntos de daño a " + enemigo.getNombre() + "\n");
				
				enemigoAtaca();
			}
		});
		
		pocionVidaButton = new JButton("Poción vida");
		pocionVidaButton.setForeground(Color.GREEN);
		
		panel_2.add(pocionVidaButton);
		
		pocionVidaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Personaje personaje = sesion.getPersonaje();
				PocionVida pocion = personaje.getPocionVida();
				int recupera = pocion.getVidaRecuperada();
				
				textArea.append("Te bebes " + pocion.getNombre() + " y recuperas " + recupera + " vida\n");
				personaje.recuperaVida(recupera);
				personaje.quitaObjeto(pocion);
				actualizaBotones();
				
				enemigoAtaca();
			}
		});
		
		continuarButton = new JButton("Continuar");
		panel_2.add(continuarButton);
		
		continuarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//xxx
				//v.cambiaPantalla(new CombatePanel(v, sesion, JuegoPanel.this));
			}
		});
		
		salirButton = new JButton("Salir");
		panel_2.add(salirButton);
		
		salirButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		pocionManaButton = new JButton("Poción maná");
		pocionManaButton.setForeground(Color.GREEN);
		panel_2.add(pocionManaButton);
		
		
		textArea = new JTextArea();
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		add(textArea, BorderLayout.CENTER);
		
		pocionManaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mago personaje = (Mago) sesion.getPersonaje();
				PocionMana pocion = personaje.getPocionMana();
				int recupera = pocion.getManaRecuperada();
				
				textArea.append("Te bebes " + pocion.getNombre() + " y recuperas " + recupera + " maná\n");
				personaje.recuperaMana(recupera);
				personaje.quitaObjeto(pocion);
				actualizaBotones();
				
				enemigoAtaca();
			}
		});

		actualizaBotones();
	}
	
	public void enemigoAtaca() {
		if (enemigo.estaVivo()) {
			int danno = random.nextInt(enemigo.getAtaque());
			
			personaje.restaVida(danno);
			personajeBar.setValue(personaje.getVida());
			
			textArea.append(enemigo.getNombre() + " hizo " + danno + " puntos de daño\n");
		    
		    if (!personaje.estaVivo()) {
		    	textArea.append("Has sido derrotado por " + enemigo.getNombre() + "\n");
		    	gameOver = true;
		    }
		} else {
			textArea.append(enemigo.getNombre() + " ha sido derrotado\n");
			enemigoDerrotado = true;
		}
	}

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
			
			if (personaje instanceof Mago) {
				Mago mago = (Mago) personaje;
				
				manaBar.setVisible(true);
				
				atacarButton.setVisible(false);
				
				hechizo1Button.setVisible(true);
				hechizo2Button.setVisible(true);
				
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
