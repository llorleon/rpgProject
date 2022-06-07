package dyc.exception;

/**
 * Exception lanzada cuando no haya ninguna clase o alguna clase insertada en la BD
 * 
 * @author victorml
 *
 */

public class ClaseException extends Exception {

	private static final long serialVersionUID = -1437563929303632928L;

	public ClaseException() {
		super();
	}

	public ClaseException(String message) {
		super(message);
	}

}
