package dyc.gui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	private JPanel pantallaActual;
	public Ventana() throws SQLException {
		this.setIconImage(new ImageIcon("./logo.png").getImage());
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Dungeon & Goblins");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.pantallaActual=new SeleccionPersonaje(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
		
	}

}
