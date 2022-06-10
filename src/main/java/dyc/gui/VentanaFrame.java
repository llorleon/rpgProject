package dyc.gui;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dyc.clases.Sesion;

/**
 * Frame que sera usado como contenedor de todos los Jpanel
 * @author victorml
 *
 */
public class VentanaFrame extends JFrame {
	
	private static final long serialVersionUID = 7034760431371082687L;
	
	public VentanaFrame(Sesion sesion) throws SQLException {
		setIconImage(new ImageIcon("./logo.png").getImage());
		setSize(600, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Dungeon & Goblins");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cambiaPantalla(new SeleccionPersonajePanel(this, sesion));
	}
	
	public void cambiaPantalla(JPanel pantalla) {
		setContentPane(pantalla);
		revalidate();
	}
}
