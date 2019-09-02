package symbol;

import expression.ParserException;

/*
 * Symbol f�r eine �ffnende Klammer
 */
public class LBrSymbol implements BracketSymbol {
	
	/*
	 * Konstruktor
	 */
	public LBrSymbol() {
		
	}

	/*
	 * �berschreibt die default-Implementierung von equals
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof LBrSymbol;
	}

	@Override
	public void accept(Visitor visitor) throws ParserException {
		visitor.handleLBrSymbol(this);
	}

	
}
