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
	 * öffnende KLammer
	 */
	public static final Character LBr = '(';
	
	/*
	 * schließende Klammer
	 */
	public static final Character RBr = ')';
	
	/*
	 * String der die erlaubten Eingaben eines arithmetischen Ausdrucks enthält
	 * wird im ErrorState verwendet um zu prüfen ob ein Character ein Error ist
	 */
	public static final String allowedCharacters = "0123456789 +* ()";
	
}
