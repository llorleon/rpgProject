package dyc.exception;


/**
 * Exception lanzada cuando no haya ninguna objetos o algun objeto insertado en la BD
 * 
 * @author victorml
 *
 */

public class ObjetosException extends Exception {

	private static final long serialVersionUID = 6943017632123839327L;

	public ObjetosException() {
		super();
	}

	public ObjetosException(String message) {
		super(message);
	}

}
