/*
 * in diesem Paket werden alle Konstanten gespeichert
 */
package basic;

/*
 * Text Konstanten
 */
public abstract class TextConstants {
	
	/*
	 * leerer String
	 */
	public static final String emptyString = "";
	
	/*
	 * + Symbol der Addition
	 */
	public static final Character plus = '+';
	
	/*
	 * * Symbol der Multiplikation
	 */
	public static final Character star = '*';
	
	/*
	 * �ffnende KLammer
	 */
	public static final Character LBr = '(';
	
	/*
	 * schlie�ende Klammer
	 */
	public static final Character RBr = ')';
	
	/*
	 * String der die erlaubten Eingaben eines arithmetischen Ausdrucks enth�lt
	 * wird im ErrorState verwendet um zu pr�fen ob ein Character ein Error ist
	 */
	public static final String allowedCharacters = "0123456789 +* ()";
	
}
