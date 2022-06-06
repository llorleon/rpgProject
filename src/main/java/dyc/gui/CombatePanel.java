package dyc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import dyc.clases.Personaje;
import dyc.clases.Sesion;
import dyc.dao.Enemigo;
import dyc.dao.Mago;
import dyc.dao.PocionMana;
import dyc.dao.PocionVida;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;

public class CombatePanel extends JPanel {
	private static final long serialVersionUID = -2126587181153509748L;

	private Sesion sesion;
	private JButton pocionVidaButton;
	private JButton pocionManaButton;
	private JTextArea textArea;
	private JPanel panel_1;
	private JLabel enemigoLabel;
	private JProgressBar enemigoBar;

	public CombatePanel(VentanaFrame v, Sesion sesion, JuegoPanel juego) {
		this.sesion = sesion;
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		add(panel, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		enemigoLabel = new JLabel();
		enemigoLabel.setForeground(Color.GREEN);
		panel_1.add(enemigoLabel);
		
		enemigoBar = new JProgressBar();
		panel_1.add(enemigoBar);
		
		Enemigo enemigo = sesion.getMapa().getLugar().getEnemigo();
		enemigoLabel.setText(enemigo.getNombre());
		enemigoBar.setMaximum(enemigo.getVida());
		enemigoBar.setValue(enemigo.getVida());

		JButton atacarButton = new JButton("Atacar");
		atacarButton.setForeground(Color.GREEN);
		panel.add(atacarButton);
		
		atacarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enemigo.restaVida(sesion.getPersonaje().getAtaque());
				enemigoBar.setValue(enemigo.getVida());
			}
		});

		pocionVidaButton = new JButton("Poción vida");
		pocionVidaButton.setForeground(Color.GREEN);
		panel.add(pocionVidaButton);
		
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
			}
		});

		pocionManaButton = new JButton("Poción maná");
		pocionManaButton.setForeground(Color.GREEN);
		panel.add(pocionManaButton);
		
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
			}
		});

		actualizaBotones();
	}

	public void actualizaBotones() {
		int nPociones = sesion.getPersonaje().cuantasPocionesMana();

		if (sesion.getPersonaje() instanceof Mago && nPociones > 0) {
			pocionManaButton.setText("Poción maná x" + nPociones);
			pocionManaButton.setVisible(true);
		} else {
			pocionManaButton.setVisible(false);
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
