package dyc;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dyc.clases.Sesion;
import dyc.dao.Arquero;
import dyc.dao.Guerrero;
import dyc.dao.Mago;
import dyc.exception.ClaseException;
import dyc.exception.EnemigoException;
import dyc.exception.ObjetosException;
import dyc.gui.ResumenPanel;
import dyc.gui.VentanaFrame;

/**
 * Clase principal, desde donde llamamos a la ventana e iniciamos el juego con Sesion
 * 
 * @author victorml
 *
 */
public class Main {

	/**
	 * Metodo principal del programa donde inciamos el JFrame Ventana para mostrar interfaz grafica y donde llamamos a la sesion del juego
	 * para iniciarla
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Iniciada VentanaFrame v que sera el frame que contenga todos los JPanel
		 */
		VentanaFrame v;
		/**
		 * Iniciada Sesion sesion que contendra todo lo referente al personaje y al mapa para iniciar la partida
		 * 
		 */
		Sesion sesion;

		/**
		 * En este try catch, creamos los argumentos para que de manera automatica, si tenemos alguna de estas clases por argumentos
		 * empecemos la partida con una clase automaticamente
		 */
		try {
			sesion = new Sesion(); 
			v = new VentanaFrame(sesion);
			
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("guerrero")) {
					Guerrero guerrero = new Guerrero();
					sesion.setPersonaje(guerrero);
					v.cambiaPantalla(new ResumenPanel(v, sesion));
				} else if (args[0].equalsIgnoreCase("arquero")) {
					Arquero arquero = new Arquero();
					sesion.setPersonaje(arquero);
					v.cambiaPantalla(new ResumenPanel(v, sesion));
				} else if (args[0].equalsIgnoreCase("mago")) {
					Mago mago = new Mago();
					sesion.setPersonaje(mago);
					v.cambiaPantalla(new ResumenPanel(v, sesion));
				}
			}
			
			v.setVisible(true);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ObjetosException oe) {
			JOptionPane.showMessageDialog(null, oe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			oe.printStackTrace();
		} catch (ClaseException ce) {
			JOptionPane.showMessageDialog(null, ce.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			ce.printStackTrace();
		} catch (EnemigoException ee) {
			JOptionPane.showMessageDialog(null, ee.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			ee.printStackTrace();
		}

	}

}
