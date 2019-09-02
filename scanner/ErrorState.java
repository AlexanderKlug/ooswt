package scanner;

import basic.TextConstants;
import symbol.ErrorToken;

/*
 * Zustand bei Einlesen eines Charackters der nicht in einem arithmetischen Ausdruck vorkommen darf
 */
public class ErrorState extends State {
	private StringBuilder result; 
	
	/*
	 * Konstruktor
	 */
	public ErrorState(Scanner scanner) {
		super(scanner);
		this.result = new StringBuilder();
	}

	@Override
	public void scan(Character c) {
		if (this.isErrorToken(c)) {
			result.append(c);
			this.getMyScanner().skip();
		} else {
			this.exit();
			this.endOfProcessing();
		}
	}

	@Override
	public void exit() {
		this.getMyScanner().addSymbol(new ErrorToken(result.toString()));
	}
	
	/*
	 * prüft ob ein Character c ein erlaubter Character ist oder nicht
	 */
	private boolean isErrorToken (Character c) {
		return !(TextConstants.allowedCharacters.contains(c.toString()));
	}
}
