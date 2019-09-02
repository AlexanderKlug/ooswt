package scanner;

import basic.TextConstants;

/*
 * w�hlt den n�chsten Zustand abh�ngig vom n�chsten Symbol aus	
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
		if(Character.isDigit(c)) {				// pr�ft ob c eine Zahl ist
			this.getMyScanner().setState(new DigitState(this.getMyScanner()));
		}
		else if(Character.isWhitespace(c)) {	// pr�ft ob c ein Leerzeichen ist
			this.getMyScanner().setState(new WhitespaceState(this.getMyScanner()));
		}
		else if(c.equals(TextConstants.plus)) {	// pr�ft ob c "+" ist - Addition
			this.getMyScanner().setState(new PlusState(this.getMyScanner()));
		}
		else if(c.equals(TextConstants.star)) {	// pr�ft ob c "*" ist - Multiplikation
			this.getMyScanner().setState(new StarState(this.getMyScanner()));
		}
		else if(c.equals(TextConstants.LBr)) {	//	pr�ft ob c eine �ffnende Klammer ist
			this.getMyScanner().setState(new LBrState(this.getMyScanner()));
		}
		else if(c.equals(TextConstants.RBr)) {	// pr�ft ob c eine schlie�ende Klammer ist
			this.getMyScanner().setState(new RBrState(this.getMyScanner()));
		}
		else {									// wenn alle vorherigen Pr�fungen fehl schlagen muss c ein Error sein
			this.getMyScanner().setState(new ErrorState(this.getMyScanner()));
		}
		

	}
}
