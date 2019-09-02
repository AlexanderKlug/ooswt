package scanner;
import java.util.ArrayList;
import basic.*;
import symbol.*;
import java.util.List;

/*
 * Scanner um einen String in eine Liste aus Symbolen umzuwandeln
 */
public class Scanner {

	private String currentExpression;		// String aus dem die Symbole extrahiert werden	
	private List <Symbol> currentResult;	// Liste in der die gescannten Symbole gesammelt werden
	private State currentState;				// Zustand des Scanners
	
	/*
	 * Konstruktor
	 */
	public Scanner() {					// wichtig alle Attribute mit dem Konstruktor initialisieren
		this.currentExpression = TextConstants.emptyString;
		this.currentResult = new ArrayList<Symbol>();
		this.currentState = new SelectionState(this);
	}
	
	/*
	 * ändert den Status des Scanners
	 */
	public void setState(State newState) {
		this.currentState = newState;
	}
	
	/*
	 * formt einen String in eine Liste aus Symbolen um
	 */
	public List<Symbol> toSymbolSequence(String expr) {
		this.currentExpression = expr;
		
		while(currentExpression.length() > 0) {		//solange der String nicht leer ist
			this.currentState.scan(currentExpression.charAt(0));
		}
		this.currentState.exit();
		return new ArrayList<>(this.currentResult);	
	}
	
	/*
	 * löscht das erste Element des eingegebenen Strings
	 * nur wenn der String nicht leer ist
	 */
	public void skip () {
		if (currentExpression.length() > 0)
			this.currentExpression = currentExpression.substring(1);
	}
	
	/*
	 * fügt ein Symbol an currentResult an
	 */
	public void addSymbol(Symbol symbol) {
		this.currentResult.add(symbol);
	}
	
}
