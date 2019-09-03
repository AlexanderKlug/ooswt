package expression;

/*
 * thrown  if the entered expression has an incorrent syntax
 */
public class ParserException extends java.lang.Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Konstruktor
	 */
	public ParserException (String message) {
		super(message);
	}
}
