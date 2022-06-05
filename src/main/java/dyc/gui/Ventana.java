package dyc.gui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dyc.clases.Sesion;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = 7034760431371082687L;
	
	private JPanel pantallaActual;
	public Ventana(Sesion sesion) throws SQLException {
		this.setIconImage(new ImageIcon("./logo.png").getImage());
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Dungeon & Goblins");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pantallaActual=new SeleccionPersonaje(this, sesion);
		this.setContentPane(this.pantallaActual);
		
	}

}
