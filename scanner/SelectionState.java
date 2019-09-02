package scanner;

import basic.TextConstants;

/*
 * wählt den nächsten Zustand abhängig vom nächsten Symbol aus	
 */
public class SelectionState extends State {
	
	/*
	 * Konstruktor
	 */
	public SelectionState(Scanner scanner) {
		super(scanner);
	}

	@Override
	public void scan(Character c) {
		if(Character.isDigit(c)) {				// prüft ob c eine Zahl ist
			this.getMyScanner().setState(new DigitState(this.getMyScanner()));
		}
		else if(Character.isWhitespace(c)) {	// prüft ob c ein Leerzeichen ist
			this.getMyScanner().setState(new WhitespaceState(this.getMyScanner()));
		}
		else if(c.equals(TextConstants.plus)) {	// prüft ob c "+" ist - Addition
			this.getMyScanner().setState(new PlusState(this.getMyScanner()));
		}
		else if(c.equals(TextConstants.star)) {	// prüft ob c "*" ist - Multiplikation
			this.getMyScanner().setState(new StarState(this.getMyScanner()));
		}
		else if(c.equals(TextConstants.LBr)) {	//	prüft ob c eine öffnende Klammer ist
			this.getMyScanner().setState(new LBrState(this.getMyScanner()));
		}
		else if(c.equals(TextConstants.RBr)) {	// prüft ob c eine schließende Klammer ist
			this.getMyScanner().setState(new RBrState(this.getMyScanner()));
		}
		else {									// wenn alle vorherigen Prüfungen fehl schlagen muss c ein Error sein
			this.getMyScanner().setState(new ErrorState(this.getMyScanner()));
		}
		

	}
}
