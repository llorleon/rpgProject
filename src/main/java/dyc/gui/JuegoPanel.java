package dyc.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dyc.clases.Sesion;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class JuegoPanel extends JPanel {
	private static final long serialVersionUID = -8510474658317474918L;
	
	private Sesion sesion;
	private JTextArea textArea;
	private JButton atacarButton;
	private JButton huirButton;
	private JButton recogerButton;
	private JButton siguienteButton;

	public JuegoPanel(VentanaFrame v, Sesion sesion) {
		this.sesion = sesion;
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		textArea.setLineWrap(true);
		add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		atacarButton = new JButton("Atacar");
		atacarButton.setForeground(Color.GREEN);
		panel.add(atacarButton);
		
		atacarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiaPantalla(new CombatePanel(v, sesion, JuegoPanel.this));
			}
		});
		
        siguienteButton = new JButton("Siguiente");
		siguienteButton.setForeground(Color.GREEN);
		panel.add(siguienteButton);
		
		siguienteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sesion.getMapa().avanzaLugar();
				actualizaLugar();
				actualizaBotones();
			}
		});
		
		huirButton = new JButton("Huir");
		huirButton.setForeground(Color.GREEN);
		panel.add(huirButton);
		
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
				}
			}
		});
		
		recogerButton = new JButton("Recoger");
		recogerButton.setForeground(Color.GREEN);
		panel.add(recogerButton);
		
		recogerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.append("Has cogido " + sesion.getMapa().getLugar().getPocion().getNombre() + "\n");
				sesion.getPersonaje().coge(sesion.getMapa().getLugar().getPocion());
				sesion.getMapa().getLugar().setPocion(null);
				actualizaBotones();
			}
		});
		
		setVisible(true);
		
		actualizaLugar();
		actualizaBotones();
	}
	
	public void actualizaLugar() {
		textArea.append(sesion.getMapa().getLugar().toString() + "\n");
	}
	
	public void actualizaBotones() {
		if (sesion.getMapa().getLugar().getEnemigo() != null) {
			atacarButton.setVisible(true);
			huirButton.setVisible(true);
			recogerButton.setVisible(false);
			siguienteButton.setVisible(false);
		} else if (sesion.getMapa().getLugar().getPocion() != null) {
			atacarButton.setVisible(false);
			huirButton.setVisible(false);
			recogerButton.setVisible(true);
			siguienteButton.setVisible(true);
		} else {
			atacarButton.setVisible(false);
			huirButton.setVisible(false);
			recogerButton.setVisible(false);
			siguienteButton.setVisible(true);
		}
	}

}
