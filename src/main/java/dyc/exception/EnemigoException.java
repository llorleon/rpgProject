package dyc.exception;


/**
 * Exception lanzada cuando no hay Enemigos insertados en la BD
 * 
 * @author victorml
 *
 */
public class EnemigoException extends Exception {
	private static final long serialVersionUID = 2383273124625769308L;

	public EnemigoException() {
		super();
	}
	
	public EnemigoException(String message) {
		super(message);
	}
}
